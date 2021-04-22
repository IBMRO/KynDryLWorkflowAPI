/**
 * 
 */
package com.kyndryl.ro.workflow.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abdul
 *
 */

@RestController
@RequestMapping(value = "workflow")
public class WorkflowController {

	@GetMapping(value = "/version")
	public String getVersion() {

		return "V1. HostName: " + System.getenv("HOSTNAME");
	}

}
