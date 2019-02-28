/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseQuery
 * Author:   shibun
 * Date:     2019/2/27 19:35
 * Description: 封装公共查询类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.query;

/**
 *
 * 封装公共查询类
 *
 * @author shibun
 * @create 2019/2/27
 * @since 1.0.0
 */
public class BaseQuery {

    private Integer page=1;

    private Integer rows=10;
    //从哪里开始
    private Integer start =0;
    //查询的关键字
    private String keyword;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}