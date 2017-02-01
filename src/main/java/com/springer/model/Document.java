package com.springer.model;

import java.util.UUID;

/**
 * Created by arpit on 2/1/17.
 */
public class Document {


  private Long id;
  private String title;
  private String author;
  private Watermark watermark = null;
  private String type;
  private UUID ticketID;
  private Watermark.Topic topic;

  public Document(final Long id, final String title, final String author, final Watermark watermark, final String type, final UUID ticketID)
  {
    this.id = id;
    this.title = title;
    this.author = author;
    this.watermark = watermark;
    this.type = type;
    this.ticketID = ticketID;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(final Long id)
  {
    this.id = id;
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

  public String getType()
  {
    return type;
  }

  public void setType(final String type)
  {
    this.type = type;
  }

  public Watermark getWatermark()
  {
    return watermark;
  }

  public void setWatermark(final Watermark watermark)
  {
    this.watermark = watermark;
  }

  public void setTicketID(final UUID ticketID)
  {
    this.ticketID = ticketID;
  }

  public UUID getTicketID()
  {
    return ticketID;
  }

  public Watermark.Topic getTopic()
  {
    return topic;
  }

  public void setTopic(final Watermark.Topic topic)
  {
    this.topic = topic;
  }

  @Override
  public String toString()
  {
    return "Document{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", author='" + author + '\'' +
      ", watermark=" + watermark +
      ", type='" + type + '\'' +
      ", ticketID=" + ticketID +
      '}';
  }
}
