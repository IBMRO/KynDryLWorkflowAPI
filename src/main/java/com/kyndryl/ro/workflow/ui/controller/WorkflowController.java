/**
 * 
 */
package com.kyndryl.ro.workflow.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abdul
 *
 */

@RestController
@RequestMapping(value = "workflow")
public class WorkflowController {

	@GetMapping(value = "/request/{reqId}")
	public String getVersion(@PathVariable("reqId") String reqId) {

		Map<String, HashMap<String, WorkflowController>> map = new HashMap();
		List<HashMap> myL = new ArrayList<HashMap>();
		StringBuffer memoryDetails = new StringBuffer();
		try {
			System.out.println("Processing reqId: " + reqId);

			HashMap h2 = null;
			for (int i = 1; i <= 500000; i++) {
				h2 = new HashMap<String, WorkflowController>();
				h2.put(reqId + new Random().nextInt(), new WorkflowController());
				myL.add(h2);
				map.put(reqId + new Random().nextInt(), h2);
			}

			Runtime runtime = Runtime.getRuntime();
			// Run the garbage collector
			// runtime.gc();
			// Calculate the used memory

			long memory = runtime.totalMemory() - runtime.freeMemory();
			System.out.println("Max memory is Megabytes: " + bytesToMegabytes(runtime.maxMemory()));
			memoryDetails.append(", Max Memory: " + bytesToMegabytes(runtime.maxMemory()));
			System.out.println("Total memory is Megabytes: " + bytesToMegabytes(runtime.totalMemory()));
			memoryDetails.append(", Total Memory: " + bytesToMegabytes(runtime.totalMemory()));
			System.out.println("Used memory is bytes: " + memory);
			memoryDetails.append(", Used Memory: " + bytesToMegabytes(memory));
			System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));

			System.out.println(
					"Processing Done reqId: " + reqId + " Added few objects. Size: " + map.size() + ". Going to Sleep");

			Thread.sleep(1000 * 30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "V1. HostName: " + System.getenv("HOSTNAME") + " Memeory Details: " + memoryDetails.toString();
	}

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	@GetMapping(value = "/version")
	public String getVersion() {

		return "V1. HostName: " + System.getenv("HOSTNAME");
	}

}
