/*
 * This file is generated by jOOQ.
 */
package learn_jooq.gaoxiaobu.generated.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 新闻表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S9News implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private String        title;
    private String        content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public S9News() {}

    public S9News(S9News value) {
        this.id = value.id;
        this.title = value.title;
        this.content = value.content;
        this.createTime = value.createTime;
        this.updateTime = value.updateTime;
    }

    public S9News(
        Integer       id,
        String        title,
        String        content,
        LocalDateTime createTime,
        LocalDateTime updateTime
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * Getter for <code>learn-jooq.s9_news.id</code>. ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>learn-jooq.s9_news.id</code>. ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>learn-jooq.s9_news.title</code>. 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter for <code>learn-jooq.s9_news.title</code>. 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for <code>learn-jooq.s9_news.content</code>. 内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Setter for <code>learn-jooq.s9_news.content</code>. 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter for <code>learn-jooq.s9_news.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    /**
     * Setter for <code>learn-jooq.s9_news.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter for <code>learn-jooq.s9_news.update_time</code>. 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    /**
     * Setter for <code>learn-jooq.s9_news.update_time</code>. 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("S9News (");

        sb.append(id);
        sb.append(", ").append(title);
        sb.append(", ").append(content);
        sb.append(", ").append(createTime);
        sb.append(", ").append(updateTime);

        sb.append(")");
        return sb.toString();
    }
}
