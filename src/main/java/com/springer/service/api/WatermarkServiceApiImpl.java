package com.springer.service.api;

import java.util.UUID;
import com.springer.controller.WatermarkController;
import com.springer.model.Document;
import com.springer.service.api.WatermarkServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arpit on 2/1/17.
 */
@RestController
public class WatermarkServiceApiImpl{

  @Autowired
  WatermarkController m_controller;

  /**
   * Method to add watermark to the document
   * @param id: id of the document
   * @return response code of the action
   */
  @RequestMapping(value = "add/{id}" , method = RequestMethod.GET)
  @ResponseBody
  public UUID watermarkDocument(@PathVariable final Long id)
  {
    try {
      return m_controller.setWaterMarkAndReturnTicket(id);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  /**
   * Method to check the status of watermark of the document
   * @param ticket: ticket id of the document
   * @return
   */
  @RequestMapping(value = "checkStatus/{ticket}", method = RequestMethod.GET)
  @ResponseBody
  public String checkWatermarkingStatusByTicket(@PathVariable final UUID ticket)
  {
    return m_controller.checkStatus(ticket);
  }

  /**
   * Method to check the status of watermark of the document
   * @param ticket: ticket id of the document
   */
  @RequestMapping(value = "retrieveDocument/{ticket}", method = RequestMethod.GET)
  @ResponseBody
  public Document retrieveDocumentByTicket(@PathVariable final UUID ticket)
  {
    try {
      return  m_controller.retrieveDocument(ticket);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
