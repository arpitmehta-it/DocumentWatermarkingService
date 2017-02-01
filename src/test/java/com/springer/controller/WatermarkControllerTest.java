package com.springer.controller;


import com.springer.model.Watermark;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import junit.framework.TestCase;
import com.springer.controller.WatermarkController;
import com.springer.model.Document;
import com.springer.model.DocumentRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

/**
 * Created by arpit on 2/1/17.
 */

public class WatermarkControllerTest {

  DocumentRepository repository  = Mockito.mock(DocumentRepository.class);
  private static Map<Long, Document> documentRepository = new HashMap<>();
  WatermarkController controller = new WatermarkController();

  @BeforeClass
  public static void initTest() {
    Document book1 = new Document(1L, "The Dark Code", "Bruce Wayne", null, "book",null);
    book1.setTopic(Watermark.Topic.SCIENCE);
    Document book2 = new Document(2L, "How to make money", "Dr. Evil", null, "book",null);
    book2.setTopic(Watermark.Topic.BUSINESS);
    Document journal1 = new Document(3L, "Journal of human flight routes", "Clark Kent", null, "journal", null );
    documentRepository.put(book1.getId(), book1);
    documentRepository.put(book2.getId(), book2);
    documentRepository.put(journal1.getId(), journal1);
  }


  @Test
  public void setWaterMarkAndReturnTicketWithCorrectID() {
    when(repository.getDocumentRepository()).thenReturn(documentRepository);
    UUID ticket = null;
    try {
      ticket = controller.setWaterMarkAndReturnTicket(1L);
    } catch (Exception e ){
      System.err.println(e.getMessage());
    }
    assertNotNull(ticket);
  }

  @Test(expected = Exception.class)
  public void setWaterMarkAndReturnTicketWithIncorrectID() throws Exception
  {
    when(repository.getDocumentRepository()).thenReturn(documentRepository);
    UUID ticket = controller.setWaterMarkAndReturnTicket(23L);
    fail("should not reached here");
  }

}
