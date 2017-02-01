package com.springer.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.springer.model.Book;
import com.springer.model.Document;
import com.springer.model.DocumentRepository;
import com.springer.model.Journal;
import com.springer.model.Watermark;
import org.springframework.stereotype.Component;

/**
 * Created by arpit on 2/1/17.
 */
@Component
public class WatermarkController {
  DocumentRepository m_repository = new DocumentRepository();
  Map<Long, Document> documentRepository = m_repository.getDocumentRepository();
  Map<UUID, Document> watermarkedDocumentRepository = m_repository.getWatermarkedDocumentRepository();
  Map<UUID, Date> watermarkedDocumentTimestamp = new HashMap<>();
  private static final int WATERMARKING_DURATION = 10000;

  public UUID setWaterMarkAndReturnTicket(final Long id) throws Exception {
    Document document = getDocumentById(id);
    if(document == null) {
      throw new Exception("No document with id " + id + " found in the repository !! ");
    }
    Watermark watermark = null;
    if (document instanceof Book) {
      Book book = (Book) document;
      watermark = new Watermark("book", book.getTitle(), book.getAuthor(), book.getTopic());
    } else if (document instanceof Journal){
      watermark = new Watermark("journal", document.getTitle(), document.getAuthor(), null);
    } else {
      throw new Exception("Feeling miserable !! I'm afraid something went wrong");
    }
    document.setWatermark(watermark);
    UUID ticketID = UUID.randomUUID();
    document.setTicketID(ticketID);
    watermarkedDocumentRepository.put(ticketID, document);
    watermarkedDocumentTimestamp.put(ticketID, new Date());
    return ticketID;
  }

  public String checkStatus(final UUID ticket) {
    try {
      Boolean isProcessed =  getWaterMarketTimestampByTicket(ticket);
      return isProcessed ? "Watermarking process is complete" : "Watermarking in process";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  public Document retrieveDocument(final UUID ticket) throws Exception {
    Document document = getWaterMarketDocumentByTicket(ticket);
    if(document == null) {
      throw new Exception("No document with id " + ticket + " found in the repository !! ");
    }
    return getWaterMarketDocumentByTicket(ticket);
  }

  private Document getDocumentById(Long id) {
      return documentRepository.get(id);
  }

  private Document getWaterMarketDocumentByTicket(UUID ticketID) {
      return watermarkedDocumentRepository.get(ticketID);
  }

  /**
   * Assuming watermarking process takes 10 seconds.
   * Method check of the timestamp of Watermarking request is 10 seconds earlier
   * then return True else False
   * @param ticketID
   */
  private Boolean getWaterMarketTimestampByTicket(UUID ticketID) throws Exception
  {
    if(watermarkedDocumentTimestamp.get(ticketID) != null ) {
      Date timeStampOfWatermarking = watermarkedDocumentTimestamp.get(ticketID);
      return ((new Date().getTime() - timeStampOfWatermarking.getTime()) > WATERMARKING_DURATION);
    } else {
      throw new Exception("No watermarking request with ticketID " + ticketID+ " exists in the system");
    }
  }
}
