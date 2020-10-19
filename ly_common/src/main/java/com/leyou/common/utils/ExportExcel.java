package com.leyou.common.utils;


import com.google.common.collect.Lists;
import com.leyou.common.entity.Reflections;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

public class ExportExcel {
    /**
     * 工作薄对象
     */
    private XSSFWorkbook wb;

    /**
     * 工作表对象
     */
    private Sheet sheet;

    /**
     * 样式列表
     */
    private Map<String, CellStyle> styles;

    /**
     * 当前行号
     */
    private int rownum;

    /**
     * 注解列表（Object[]{ ExcelField, Field/Method }）
     */
    List<Object[]> annotationList = Lists.newArrayList();

    /**
     * 构造函数
     *
     * @param title
     *            表格标题，传“空值”，表示无标题
     * @param cls
     *            实体对象，通过annotation.ExportField获取标题
     */
    public ExportExcel(String title, Class<?> cls) {
        this(title, cls, 1);
    }

    /**
     * 构造函数
     *
     * @param title
     *            表格标题，传“空值”，表示无标题
     * @param cls
     *            实体对象，通过annotation.ExportField获取标题
     * @param type
     *            导出类型（1:导出数据；2：导出模板）
     * @param groups
     *            导入分组
     */
    public ExportExcel(String title, Class<?> cls, int type, int... groups) {
        // Get annotation field
        Field[] fs = cls.getDeclaredFields();
        for (Field f : fs) {
            ExcelField ef = f.getAnnotation(ExcelField.class);
            if (ef != null && (ef.type() == 0 || ef.type() == type)) {
                if (groups != null && groups.length > 0) {
                    boolean inGroup = false;
                    for (int g : groups) {
                        if (inGroup) {
                            break;
                        }
                        for (int efg : ef.groups()) {
                            if (g == efg) {
                                inGroup = true;
                                annotationList.add(new Object[] { ef, f });
                                break;
                            }
                        }
                    }
                } else {
                    annotationList.add(new Object[] { ef, f });
                }
            }
        }
        // Get annotation method
        Method[] ms = cls.getDeclaredMethods();
        for (Method m : ms) {
            ExcelField ef = m.getAnnotation(ExcelField.class);
            if (ef != null && (ef.type() == 0 || ef.type() == type)) {
                if (groups != null && groups.length > 0) {
                    boolean inGroup = false;
                    for (int g : groups) {
                        if (inGroup) {
                            break;
                        }
                        for (int efg : ef.groups()) {
                            if (g == efg) {
                                inGroup = true;
                                annotationList.add(new Object[] { ef, m });
                                break;
                            }
                        }
                    }
                } else {
                    annotationList.add(new Object[] { ef, m });
                }
            }
        }
        // Field sorting
        Collections.sort(annotationList, new Comparator<Object[]>() {
            public int compare(Object[] o1, Object[] o2) {
                return new Integer(((ExcelField) o1[0]).sort())
                        .compareTo(new Integer(((ExcelField) o2[0]).sort()));
            };
        });
        // Initialize
        List<String> headerList = Lists.newArrayList();
        for (Object[] os : annotationList) {
            String t = ((ExcelField) os[0]).title();
            // 如果是导出，则去掉注释
            if (type == 1) {
                String[] ss = org.apache.commons.lang3.StringUtils.split(t, "**", 2);
                if (ss.length == 2) {
                    t = ss[0];
                }
            }
            headerList.add(t);
        }
        initialize(null, title, headerList, 0);
    }

    public ExportExcel(Workbook workbook, String title, List<String> headerList) {
        initialize(workbook, title, headerList, 0);
    }

    public ExportExcel(Workbook workbook, String title, List<String> headerList, int startRowNum) {
        initialize(workbook, title, headerList, startRowNum);
    }

    public ExportExcel(List<String> headerList, Workbook workbook, String title, int startRowNum) {
        initialize(headerList,workbook, title,  startRowNum);
    }

    public ExportExcel(Workbook workbook, Sheet sheet, List<String> headerList, int startRowNum) {
        initializeSheet(workbook, sheet, headerList, startRowNum);
    }

    /**
     * 初始化函数
     *
     * @param title      表格标题，传“空值”，表示无标题
     * @param headerList 表头列表
     */
    private void initialize(List<String> headerList, Workbook workbook, String title, int startRowNum) {
        if (workbook != null) {
            this.wb = (XSSFWorkbook) workbook;
        } else {
            this.wb = new XSSFWorkbook();
        }
        this.sheet = wb.createSheet(title);
        this.styles = createStyles(wb);
        this.rownum = startRowNum;
        CreationHelper helper = wb.getCreationHelper();
        XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
        ClientAnchor anchor = helper.createClientAnchor();
        // 设置斜线的开始位置
        anchor.setCol1(0);
        anchor.setRow1(0);
        // 设置斜线的结束位置
        anchor.setCol2(1);
        anchor.setRow2(1);
        XSSFSimpleShape shape = drawing.createSimpleShape((XSSFClientAnchor) anchor);
        // 设置形状类型为线型
        shape.setShapeType(ShapeTypes.LINE);
        // 设置线宽
        shape.setLineWidth(0.5);
        // 设置线的风格
        shape.setLineStyle(0);
        // 设置线的颜色
        shape.setLineStyleColor(0, 0, 0);
        // Create title
//		if (StringUtils.isNotBlank(title)){
//			Row titleRow = sheet.createRow(rownum++);
//			titleRow.setHeightInPoints(30);
//			Cell titleCell = titleRow.createCell(0);
//			titleCell.setCellStyle(styles.get("title"));
//			titleCell.setCellValue(title);
//			sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(),
//					titleRow.getRowNum(), titleRow.getRowNum(), headerList.size()-1));
//		}
        // Create header
        if (headerList == null) {
            throw new RuntimeException("headerList not null!");
        }
        Row headerRow = sheet.createRow(rownum++);
        headerRow.setHeightInPoints(30);
        for (int i = 0; i < headerList.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellStyle(styles.get("header"));
            String[] ss = StringUtils.split(headerList.get(i), "**", 2);
            if (ss.length == 2) {
                cell.setCellValue(ss[0]);
                Comment comment = this.sheet.createDrawingPatriarch().createCellComment(
                        new XSSFClientAnchor(0, 0, 0, 0, (short) 3, 3, (short) 5, 6));
                comment.setString(new XSSFRichTextString(ss[1]));
                cell.setCellComment(comment);
            } else {
                cell.setCellValue(headerList.get(i));
            }
            sheet.autoSizeColumn(i);
        }
        for (int i = 0; i < headerList.size(); i++) {
            sheet.setColumnWidth(i, headerList.get(i).getBytes().length * 252 + 200);
//            int colWidth = sheet.getColumnWidth(i)*2;
//            sheet.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
        }
    }


    /**
    *功能描述 初始函数shell
    * @author zangliulu
    * @date 2020/4/23
    * @param workbook
    * @param sheet
    * @param headerList
    * @param startRowNum
    * @return void
    */
    private void initializeSheet(Workbook workbook, Sheet sheet, List<String> headerList, int startRowNum) {
        this.wb = (XSSFWorkbook)workbook;
        this.sheet = sheet;
        this.styles = createStyles(wb);
        this.rownum = startRowNum;
        // Create title
//		if (StringUtils.isNotBlank(title)){
//			Row titleRow = sheet.createRow(rownum++);
//			titleRow.setHeightInPoints(30);
//			Cell titleCell = titleRow.createCell(0);
//			titleCell.setCellStyle(styles.get("title"));
//			titleCell.setCellValue(title);
//			sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(),
//					titleRow.getRowNum(), titleRow.getRowNum(), headerList.size()-1));
//		}
        // Create header
        if (headerList == null){
            throw new RuntimeException("headerList not null!");
        }
        Row headerRow = sheet.createRow(rownum++);
        headerRow.setHeightInPoints(16);
        for (int i = 0; i < headerList.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellStyle(styles.get("header"));
            String[] ss = org.apache.commons.lang3.StringUtils.split(headerList.get(i), "**", 2);
            if (ss.length==2){
                cell.setCellValue(ss[0]);
                Comment comment = this.sheet.createDrawingPatriarch().createCellComment(
                        new XSSFClientAnchor(0, 0, 0, 0, (short) 3, 3, (short) 5, 6));
                comment.setString(new XSSFRichTextString(ss[1]));
                cell.setCellComment(comment);
            }else{
                cell.setCellValue(headerList.get(i));
            }
            sheet.autoSizeColumn(i);
        }
        for (int i = 0; i < headerList.size(); i++) {
            int colWidth = sheet.getColumnWidth(i)*2;
            sheet.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
        }
    }

    /**
     * 初始化函数
     * @param title 表格标题，传“空值”，表示无标题
     * @param headerList 表头列表
     */
        private void initialize(Workbook workbook, String title, List<String> headerList, int startRowNum) {
        if(workbook != null){
            this.wb = (XSSFWorkbook) workbook;
        }else{
            this.wb = new XSSFWorkbook();
        }
        this.sheet = wb.createSheet(title);
        this.styles = createStyles(wb);
        this.rownum = startRowNum;
        // Create title
//		if (StringUtils.isNotBlank(title)){
//			Row titleRow = sheet.createRow(rownum++);
//			titleRow.setHeightInPoints(30);
//			Cell titleCell = titleRow.createCell(0);
//			titleCell.setCellStyle(styles.get("title"));
//			titleCell.setCellValue(title);
//			sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(),
//					titleRow.getRowNum(), titleRow.getRowNum(), headerList.size()-1));
//		}
        // Create header
        if (headerList == null){
            throw new RuntimeException("headerList not null!");
        }
        Row headerRow = sheet.createRow(rownum++);
        headerRow.setHeightInPoints(16);
        for (int i = 0; i < headerList.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellStyle(styles.get("header"));
            String[] ss = org.apache.commons.lang3.StringUtils.split(headerList.get(i), "**", 2);
            if (ss.length==2){
                cell.setCellValue(ss[0]);
                Comment comment = this.sheet.createDrawingPatriarch().createCellComment(
                        new XSSFClientAnchor(0, 0, 0, 0, (short) 3, 3, (short) 5, 6));
                comment.setString(new XSSFRichTextString(ss[1]));
                cell.setCellComment(comment);
            }else{
                cell.setCellValue(headerList.get(i));
            }
            sheet.autoSizeColumn(i);
        }
        for (int i = 0; i < headerList.size(); i++) {
            int colWidth = sheet.getColumnWidth(i)*2;
            sheet.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
        }
    }

    /**
     * 创建表格样式
     * @param wb 工作薄对象
     * @return 样式列表
     */
    private Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont = wb.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 16);
//		titleFont.setBold(true);
        style.setFont(titleFont);
        styles.put("title", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("宋体");
        dataFont.setFontHeightInPoints((short) 11);
        style.setFont(dataFont);
        styles.put("data", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.LEFT);
        styles.put("data1", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        styles.put("data2", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        styles.put("data3", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
//		style.setWrapText(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.NO_FILL);
        Font headerFont = wb.createFont();
        headerFont.setFontName("宋体");
        headerFont.setFontHeightInPoints((short) 11);
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);

        return styles;
    }

    /**
     * 添加一行
     * @return 行对象
     */
    public Row addRow(){
        return sheet.createRow(rownum++);
    }


    /**
     * 添加一个单元格
     * @param row 添加的行
     * @param column 添加列号
     * @param val 添加值
     * @return 单元格对象
     */
    public Cell addCell(Row row, int column, Object val){
        return this.addCell(row, column, val, 0, Class.class);
    }

    /**
     * 添加一个单元格
     * @param row 添加的行
     * @param column 添加列号
     * @param val 添加值
     * @param align 对齐方式（1：靠左；2：居中；3：靠右）
     * @return 单元格对象
     */
    public Cell addCell(Row row, int column, Object val, int align, Class<?> fieldType){
        Cell cell = row.createCell(column);
        CellStyle style = styles.get("data"+(align>=1&&align<=3?align:""));
        try {
            if (val == null){
                cell.setCellValue("");
            } else if (val instanceof String) {
                cell.setCellValue((String) val);
            } else if (val instanceof Integer) {
                cell.setCellValue((Integer) val);
            } else if (val instanceof Long) {
                cell.setCellValue((Long) val);
            } else if (val instanceof Double) {
                cell.setCellValue((Double) val);
            } else if (val instanceof Float) {
                cell.setCellValue((Float) val);
            } else if (val instanceof Date) {
                DataFormat format = wb.createDataFormat();
                style.setDataFormat(format.getFormat("yyyy-MM-dd"));
                cell.setCellValue((Date) val);
            } else {
                if (fieldType != Class.class){
                    cell.setCellValue((String)fieldType.getMethod("setValue", Object.class).invoke(null, val));
                }else{
                    cell.setCellValue((String)Class.forName(this.getClass().getName().replaceAll(this.getClass().getSimpleName(),
                            "fieldtype."+val.getClass().getSimpleName()+"Type")).getMethod("setValue", Object.class).invoke(null, val));
                }
            }
        } catch (Exception ex) {
            ex.toString();
            cell.setCellValue("");
        }
        cell.setCellStyle(style);
        return cell;
    }

    /**
     * 添加数据（通过annotation.ExportField添加数据）
     * @return list 数据列表
     */
    public <E> ExportExcel setDataList(List<E> list){
        for (E e : list){
            int colunm = 0;
            Row row = this.addRow();
            StringBuilder sb = new StringBuilder();
            for (Object[] os : annotationList){
                ExcelField ef = (ExcelField)os[0];
                Object val = null;
                // Get entity value
                try{
                    if (StringUtils.isNotBlank(ef.value())){
                        val = Reflections.invokeGetter(e, ef.value());
                    }else{
                        if (os[1] instanceof Field){
                            val = Reflections.invokeGetter(e, ((Field)os[1]).getName());
                        }else if (os[1] instanceof Method){
                            val = Reflections
                                    .invokeMethod(e, ((Method)os[1]).getName(), new Class[] {}, new Object[] {});
                        }
                    }
                    // If is dict, get dict label
//					if (StringUtils.isNotBlank(ef.dictType())){
//						val = DictUtils.getDictLabel(val==null?"":val.toString(), ef.dictType(), "");
//					}
                }catch(Exception ex) {
                    // Failure to ignore
                    val = "";
                }
                this.addCell(row, colunm++, val, ef.align(), ef.fieldType());
                sb.append(val + ", ");
            }
        }
        return this;
    }

    /**
     * 输出数据流
     * @param os 输出数据流
     */
    public ExportExcel write(OutputStream os) throws IOException {
        wb.write(os);
        return this;
    }

    /**
     * 输出到客户端
     * @param fileName 输出文件名
     */
    public ExportExcel write(HttpServletResponse response, String fileName) throws IOException{
        response.reset();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\""+URLEncoder.encode(fileName,"utf-8") + "\"");
        write(response.getOutputStream());
        return this;
    }

    /**
     * 输出到文件
     * @param fileName 输出文件名
     */
    public ExportExcel writeFile(String fileName) throws FileNotFoundException, IOException{
        FileOutputStream os = new FileOutputStream(fileName);
        this.write(os);
        os.close();
        return this;
    }


    /**
     * 导出文件到客户端
     */
    public ExportExcel exportToClient(String title, String fileName, List<String> headerList, List<List<String>> dataList, HttpServletResponse response) {
        ExportExcel ee = new ExportExcel(null, title, headerList);
        for (int i = 0; i < dataList.size(); i++) {
            Row row = ee.addRow();
            for (int j = 0; j < dataList.get(i).size(); j++) {
                ee.addCell(row, j, dataList.get(i).get(j));
            }
        }

        try {
            ee = ee.write(response, fileName);
        } catch (IOException e) {
            return null;
        }

        return ee;
    }



    public Sheet getSheet() {
        return sheet;
    }
}
