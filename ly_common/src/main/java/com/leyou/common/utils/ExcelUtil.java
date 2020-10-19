package com.leyou.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

@Slf4j
public class ExcelUtil {
    private static int version2003 = 2003;
    private static int version2007 = 2007;
    private static int version = version2003;
    /**
     * CSV文件列分隔符
     */
    private static final String CSV_COLUMN_SEPARATOR = ",";

    /**
     * CSV文件行分隔符
     */
    private static final String CSV_ROW_SEPARATOR = "\r\n";


    public static List<String> readExcel(InputStream inputStream) throws Exception {
        List<String> res = new ArrayList<>();
        Workbook  workBook = WorkbookFactory.create(new BufferedInputStream(inputStream));
        Sheet sheet = workBook.getSheetAt(0);
        if(sheet != null) {
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                if(sheet.getRow(i) != null) {
                    Cell cell = sheet.getRow(i).getCell(0);
                    if(cell != null) {
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        if(StringUtils.isNotBlank(value))
                            res.add(value.trim());
                    }
                }
            }
        }
        return res;
    }



    public static Workbook readExcel(String filePath) throws Exception {
        FileInputStream fis = null;
        try {
            version = (filePath.endsWith(".xls") ? version2003 : version2007);

            fis = new FileInputStream(new File(filePath));

            if (version == version2003) {
                return new HSSFWorkbook(fis);
            }
            return new XSSFWorkbook(fis);
        } catch (Exception e) {
            log.error("读取excel表格失败", e);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return null;
    }

    /**
     * 导出文件至excel文件中
     *
     * @param title
     *            excel内容标题
     * @param headerList
     *            表头
     * @param dataList
     *            表内容
     * @param startRowNum
     *            开始行数 从0开始
     */
    public static void createSheet(Workbook wk, String title,
                                   List<String> headerList, List<List<Object>> dataList, int startRowNum) {
        ExportExcel ee = new ExportExcel(wk, title, headerList, startRowNum);
        for (int i = 0; i < dataList.size(); i++) {
            Row row = ee.addRow();
            List<Object> list = dataList.get(i);
            if (list == null) {
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                ee.addCell(row, j, list.get(j));
            }
        }
    }


    public void createSheet(Workbook wk,  Sheet sheet,
                                   List<String> headerList, List<List<Object>> dataList, int startRowNum) {
        ExportExcel ee = new ExportExcel(wk, sheet, headerList, startRowNum);
        for (int i = 0; i < dataList.size(); i++) {
            Row row = ee.addRow();
            List<Object> list = dataList.get(i);
            if (list == null) {
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                ee.addCell(row, j, list.get(j));
            }
        }
    }

    /**
     * 导出文件至excel文件中
     *
     * @param title
     *            excel内容标题
     * @param headerList
     *            表头
     * @param dataList
     *            表内容
     */
    public static void createSheet(Workbook wk, String title,
                                   List<String> headerList, List<List<Object>> dataList) {
        createSheet(wk, title, headerList, dataList, 0);
    }

    /**
     * 获取单元格的值
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {

        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {

            return cell.getStringCellValue().trim();

        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {

            return String.valueOf(cell.getBooleanCellValue());

        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

            return cell.getCellFormula();

        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

            return String.valueOf(cell.getNumericCellValue());

        }
        return null;
    }

    /**
     * 获取单元格的值
     *
     * @param cell
     * @return
     */
    public static Integer getCellNumberValue(Cell cell) {

        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            if (StringUtils.isNotBlank(cell.getStringCellValue())) {
                return Integer.parseInt(cell.getStringCellValue());
            }

        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

            return Double.valueOf(cell.getNumericCellValue()).intValue();

        }
        return null;
    }

    /**
     * 获取单元格的值
     *
     * @param cell
     * @return
     */
    public static Long getCellLongValue(Cell cell) {

        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            if (StringUtils.isNotBlank(cell.getStringCellValue())) {
                return Long.parseLong(cell.getStringCellValue());
            }

        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

            return Double.valueOf(cell.getNumericCellValue()).longValue();

        }
        return null;
    }

    /**
     * 生成为CVS文件
     *
     * @param exportData
     *            源数据List
     * @param headerList
     *            csv文件的列表头map
     * @param outPutPath
     *            文件路径
     * @param fileName
     *            文件名称
     * @return
     */
    public static File createCSVFile(List<List<Object>> exportData,
                                     List<String> headerList, String outPutPath, String fileName) {
        // 是否首次写入
        Boolean isOverWrite = true;
        File file = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            file = new File(outPutPath + fileName);
            if (!file.exists()) {
                file.createNewFile();
                isOverWrite = false;
            }
            // 定义文件名格式并创建
            log.debug("csvFile：" + file);
            // UTF-8使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true), "GBK"), 1024);
            // csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
            // new FileOutputStream(file), "GBK"), 1024);
            log.debug("csvFileOutputStream：" + csvFileOutputStream);
            // 写入文件头部
            if (!isOverWrite) {
                for (int i = 0; i < headerList.size(); i++) {
                    csvFileOutputStream
                            .write(headerList.get(i) != null ? headerList
                                    .get(i) : "");
                    if (i < headerList.size() - 1) {
                        csvFileOutputStream.write(",");
                    }
                }
                csvFileOutputStream.newLine();
            }
            // 写入文件内容
            for (int i = 0; i < exportData.size(); i++) {
                List<Object> list = exportData.get(i);
                if (list == null) {
                    continue;
                }
                for (int j = 0; j < list.size(); j++) {
                    csvFileOutputStream
                            .write(String.format(
                                    "\"%s\"",
                                    list.get(j) != null ? String.valueOf(list
                                            .get(j)) : ""));
                    if (j < list.size() - 1) {
                        csvFileOutputStream.write(",");
                    } else {
                        csvFileOutputStream.newLine();
                    }
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            log.error("csv导出失败：", e);
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                log.error("csv流关闭：", e);
            }
        }
        return file;
    }

    /**
     * 导出csv字符串
     * @param headerList  表头
     * @param dataList    集合数据
     */
    public static String exportCsv(List<String> headerList, List<List<Object>> dataList) {
        // 保证线程安全
        StringBuffer buf = new StringBuffer();
        // 组装表头
        for (String title : headerList) {
            buf.append(title).append(CSV_COLUMN_SEPARATOR);
        }
        buf.append(CSV_ROW_SEPARATOR);
        // 组装数据
        if (CollectionUtils.isNotEmpty(dataList)) {
            for (List<Object> row : dataList) {
                for (Object o : row) {
                    buf.append(o).append(CSV_COLUMN_SEPARATOR);
                }
                buf.append(CSV_ROW_SEPARATOR);
            }
        }
        return buf.toString();
    }

    /**
     * 导出输出流
     * @param headerList
     * @param dataList
     * @param os
     * @throws IOException
     */
    public static void exportCsv(List<String> headerList, List<List<Object>> dataList, OutputStream os) throws IOException {
        String csvStr = exportCsv(headerList, dataList);
        // 写出响应
        os.write(csvStr.getBytes("GBK"));
        os.flush();
    }

    /**
     * 设置Header
     *
     * @param fileName
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void setResponseHead(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        // 设置文件后缀
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fn = fileName + sdf.format(new Date()) + ".csv";
        // 读取字符编码
        String utf = "UTF-8";
        // 设置响应
        response.reset(); // 非常重要
        response.setContentType("text/csv;charset=UTF-8");
        response.setCharacterEncoding(utf);
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fn, utf));
    }

    /**
     * 导出csv放入response中
     * @param headerList
     * @param dataList
     * @param fileName
     * @param response
     * @throws Exception
     */
    public static void exportCsv(List<String> headerList, List<List<Object>> dataList, String fileName, HttpServletResponse response) throws Exception {
        OutputStream os = response.getOutputStream();
        setResponseHead(fileName, response);
        exportCsv(headerList, dataList, os);
        os.close();
    }


    /**
     * 导出excel文件
     * @param exportData 列数据
     * @param headerList 列名
     * @param fileName 文件名（不含文件类型后缀）
     * @return
     */
    public static void createExcel(List<List<Object>> exportData,
                                   List<String> headerList, String fileName , HttpServletResponse response) {
        XSSFWorkbook book = new XSSFWorkbook();
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            createSheet(book, fileName, headerList, exportData);
            response.reset(); // 非常重要
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName+".xlsx");
            book.write(out);
        } catch (Exception e) {
            log.error("导出数据异常", e);
        } finally {
            try {
                out.close();
                book.close();
            } catch (Exception e) {
                log.error("导出数据异常", e);
            }
        }
    }

    public static void createExcel(List<List<Object>> exportData,
                                   List<String> headerList, HttpServletResponse response, String fileName ){
        XSSFWorkbook book = new XSSFWorkbook();
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            createSheet(book,headerList,exportData,fileName);
            response.reset(); // 非常重要
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName+".xlsx");
            book.write(out);
        } catch (Exception e) {
            log.error("导出数据异常", e);
        } finally {
            try {
                out.close();
                book.close();
            } catch (Exception e) {
                log.error("导出数据异常", e);
            }
        }
    }

    public static void createSheet(Workbook wk,
                                   List<String> headerList,List<List<Object>> exportData, String fileName) {
        ExportExcel ee = new ExportExcel( headerList,wk, fileName, 0);
        for (int i = 0; i < exportData.size(); i++) {
            Row row = ee.addRow();
            List<Object> list = exportData.get(i);
            if (list == null) {
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                ee.addCell(row, j, list.get(j));
            }
        }
    }

    /**
     *功能描述  相同数据  导出多个sheet
     * @author zangliulu
     * @date 2020/4/23
     * @param eportDataSheets
     * @param headerListSheets
     * @param sheetNames
     * @param fileName
     * @param response
     * @return void
     */
    public void createExcel(TreeMap<String,List<List<Object>>>  eportDataSheets,
                                   TreeMap<String,List<String>>   headerListSheets, TreeMap<String,String>  sheetNames,String fileName , HttpServletResponse response) {
        XSSFWorkbook book = new XSSFWorkbook();
        OutputStream out = null;
        //多个shell导入数据
        try {
            out = response.getOutputStream();
           createSheet(book,eportDataSheets,headerListSheets,sheetNames);
            response.reset(); // 非常重要
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName+".xlsx");
            book.write(out);
        } catch (Exception e) {
            log.error("导出数据异常", e);
        } finally {
            try {
                out.close();
                book.close();
            } catch (Exception e) {
                log.error("导出数据异常", e);
            }
        }
    }

   public  void createSheet(XSSFWorkbook book,TreeMap<String,List<List<Object>>>  eportDataSheets,
                     TreeMap<String,List<String>>   headerListSheets, TreeMap<String,String>  sheetNames){
        eportDataSheets.forEach((integer, lists) ->{
            List<String> headerList = headerListSheets.get(integer);
            String shellName = sheetNames.get(integer);
            Sheet sheet = book.createSheet(shellName);
            this.createSheet(book,sheet, headerList, lists,0);
        } );
    }

    /**
     * 导出excel文件
     * @param book 工作表对象
     * @param outPutPath 输出目录
     * @param fileName 文件名（不含文件类型后缀）
     * @return
     */
    public static File createExcelFile(XSSFWorkbook book, String outPutPath, String fileName) {
        FileOutputStream os = null;
        String outputFilePath = outPutPath + "/" + fileName + ".xlsx";
        try {
            File file = new File(outputFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(outputFilePath);
            book.write(os);
            return file;
        } catch (Exception e) {
            log.error("导出数据异常", e);
            File tempFile = new File(outputFilePath);
            tempFile.deleteOnExit();
        } finally {

            try {
                if (os != null) {
                    os.close();
                }
                book.close();
            } catch (Exception e) {
                log.error("导出数据异常", e);
            }
        }
        return null;
    }

    /**
     * 添加图片
     * @param workbook
     * @param imgPath
     * @param dx1 第一个单元格的X坐标。
     * @param dy1 第一个单元格的坐标。
     * @param dx2 第二单元格的X坐标。
     * @param dy2 第二单元格的坐标。
     * @param col1 第一单元格的列（0为基础）。
     * @param row1 第一个单元格的行（0为基础）。
     * @param col2 第二单元格的列（0为基础）。
     * @param row2 第二个单元格的行（0为基础）。
     * @throws Exception
     */
    public static void insertImg(XSSFWorkbook workbook, String imgPath, int dx1, int dy1, int dx2, int dy2,
                                 int col1, int row1, int col2, int row2) throws Exception{

        XSSFSheet sheet = workbook.getSheetAt(0);
        //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
        XSSFDrawing patriarch = sheet.getDrawingPatriarch();
        if(patriarch == null){
            patriarch = sheet.createDrawingPatriarch();
        }

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        File file = new File(imgPath);

        BufferedImage bufferImg = ImageIO.read(file);
        String fileType = file.getName().substring(file.getName().lastIndexOf(".") + 1);

        ImageIO.write(bufferImg, fileType,
                byteArrayOut);
        XSSFClientAnchor anchor = new XSSFClientAnchor(dx1, dy1, dx2, dy2, col1, row1, col2, row2);
        anchor.setAnchorType(ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE);
        //插入图片
        patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(),
                getImgCode(fileType)));
    }

    /**
     * 获取图片类型的编码
     * @param fileType
     * @return
     */
    private static int getImgCode(String fileType){
        switch (fileType.toLowerCase()){
            case "png":
                return Workbook.PICTURE_TYPE_PNG;
            default:
                return Workbook.PICTURE_TYPE_JPEG;
        }
    }
}
