package com.springer.model;

/**
 * Created by arpit on 2/1/17.
 */
public class Watermark {

  String content;
  String title;
  String author;
  public enum Topic { BUSINESS, SCIENCE, MEDIA}
  Topic topic;

  public Watermark(final String content, final String title, final String author, final Topic topic)
  {
    this.content = content;
    this.title = title;
    this.author = author;
    if(topic !=null) {
      this.topic = topic;
    }
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(final String content)
  {
    this.content = content;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(final String title)
  {
    this.title = title;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(final String author)
  {
    this.author = author;
  }

  public Topic getTopic()
  {
    return topic;
  }

  public void setTopic(final Topic topic)
  {
    this.topic = topic;
  }

  @Override
  public String toString()
  {
    if(topic == null) {
      return "{" +
        "content='" + content + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author +
        '}';
    }
    return "{" +
      "content='" + content + '\'' +
      ", title='" + title + '\'' +
      ", author='" + author + '\'' +
      ", topic=" + topic +
      '}';
  }
}
