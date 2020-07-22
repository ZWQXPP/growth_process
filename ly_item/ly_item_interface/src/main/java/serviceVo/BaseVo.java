package serviceVo;

import lombok.Data;

@Data
public class BaseVo {

    /**
     * @Fields  : 页数
     * @author qiaomengnan
     */
    private Integer page;

    /**
     * @Fields  : 记录数
     * @author qiaomengnan
     */
    private Integer limit;


    /**
     * @Title:
     * @Description:   返回页数
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2019/06/25 03:17:54
     */
    public Integer getPage(){
        return page == null ? 1 : page;
    }

    /**
     * @Title:
     * @Description:   返回记录数
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2019/06/25 03:17:58
     */
    public Integer getLimit(){
        return limit == null ? 10 : limit;
    }

}
