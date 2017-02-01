package com.springer.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by arpit on 2/1/17.
 */
public class DocumentRepository {

  public DocumentRepository()
  {
    init();
  }

  private void init() {
    Book book1 = new Book(1L, "The Dark Code", "Bruce Wayne", null, "book",null);
    book1.setTopic(Watermark.Topic.SCIENCE);
    Book book2 = new Book(2L, "How to make money", "Dr. Evil", null, "book",null);
    book2.setTopic(Watermark.Topic.BUSINESS);
    Journal journal1 = new Journal(3L, "Journal of human flight routes", "Clark Kent", null, "journal", null );
    documentRepository.put(book1.getId(), book1);
    documentRepository.put(book2.getId(), book2);
    documentRepository.put(journal1.getId(), journal1);
    }

    private Map<Long, Document> documentRepository = new HashMap<>();
    private Map<UUID, Document> watermarkedDocumentRepository = new HashMap<>();

    public Map<Long, Document> getDocumentRepository() {
      return documentRepository;
    }

    public Map<UUID, Document> getWatermarkedDocumentRepository()
    {
      return watermarkedDocumentRepository;
    }
}
