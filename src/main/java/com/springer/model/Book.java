package com.springer.model;

import java.util.UUID;

/**
 * Created by arpit on 2/1/17.
 */
public class Book extends Document {
  private String content;
  private Watermark.Topic topic;

  public Book(final Long id, final String title, final String author, final Watermark watermark, final String type, final UUID ticketID)
  {
    super(id, title, author, watermark, type, ticketID);
  }


  public Watermark.Topic getTopic()
  {
    return topic;
  }

  public void setTopic(final Watermark.Topic topic)
  {
    this.topic = topic;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(final String content)
  {
    this.content = content;
  }

  @Override
  public String toString()
  {
    return "Book{" +
      "content='" + content + '\'' +
      ", topic=" + topic +
      '}';
  }
}
