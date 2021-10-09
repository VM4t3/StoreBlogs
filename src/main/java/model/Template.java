package model;

/*
	template_id INT UNSIGNED AUTO_INCREMENT,
    background_color VARCHAR(50),
	title_color VARCHAR(50),
    content_color VARCHAR(50),
	title_font VARCHAR(50),
    content_font VARCHAR(50),
	PRIMARY KEY (template_id)
*/

public class Template {

    int templateId;
    String backgroundColor;
    String titleColor;
    String contentColor;
    String titleFont;
    String contentFont;

    public Template(int templateId, String backgroundColor, String titleColor, String contentColor, String titleFont, String contentFont) {
        this.templateId = templateId;
        this.backgroundColor = backgroundColor;
        this.titleColor = titleColor;
        this.contentColor = contentColor;
        this.titleFont = titleFont;
        this.contentFont = contentFont;
    }

    public int getTemplateId() {
        return templateId;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public String getContentColor() {
        return contentColor;
    }

    public String getTitleFont() {
        return titleFont;
    }

    public String getContentFont() {
        return contentFont;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public void setContentColor(String contentColor) {
        this.contentColor = contentColor;
    }

    public void setTitleFont(String titleFont) {
        this.titleFont = titleFont;
    }

    public void setContentFont(String contentFont) {
        this.contentFont = contentFont;
    }
}
