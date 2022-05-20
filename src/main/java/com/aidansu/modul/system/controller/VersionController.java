package com.aidansu.modul.system.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统版本
 *
 * @author aidansu
 */
@RestController
public class VersionController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${spring.application.version: }")
	private String version;

	@Value("${spring.profiles.active}")
	private String active;

	@GetMapping(value = "/version")
	public String version() {
		return version;
	}

	@GetMapping(value = "/version-info")
	public String versionInfo() {
		return applicationName+" : "+version+" "+active;
	}

}
