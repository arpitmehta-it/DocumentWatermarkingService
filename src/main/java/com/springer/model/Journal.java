package com.springer.model;

import java.util.UUID;

/**
 * Created by arpit on 2/1/17.
 */
public class Journal extends Document {

  private String content;

  public Journal(final Long id, final String title, final String author, final Watermark watermark, final String type, final UUID ticketID)
  {
    super(id, title, author, watermark, type, ticketID);
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
    return "Journal{" +
      "content='" + content + '\'' +
      '}';
  }
}
