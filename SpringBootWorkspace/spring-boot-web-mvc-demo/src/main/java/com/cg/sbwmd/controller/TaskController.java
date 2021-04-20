package com.cg.sbwmd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TaskController {
	public static final String VIEW_NAME = "task-list";
	public static final String MODEL_OBJECT_NAME = "tasks"; 

	private List<String> taskList;
	
	public TaskController() {
		this.taskList = new ArrayList<>();
	}
	
	@GetMapping(path = "/task")
	public ModelAndView showAllTasksAction() {
		return new ModelAndView(VIEW_NAME, MODEL_OBJECT_NAME, taskList);
	}
	
	@GetMapping(path = "/addTask")
	public ModelAndView addTaskAction(@RequestParam(value = "task") String taskName) {
		this.taskList.add(taskName);
		return new ModelAndView(VIEW_NAME, MODEL_OBJECT_NAME, taskList);
	}
	
	@GetMapping(path = "/deleteTask")
	public ModelAndView deleteTaskAction(@RequestParam(value = "task") String taskName) {
		this.taskList.remove(taskName);
		return new ModelAndView(VIEW_NAME, MODEL_OBJECT_NAME, taskList);
	}
	
	@GetMapping(path = "/clearTasks")
	public ModelAndView clearTasksAction() {
		this.taskList.clear();
		return new ModelAndView(VIEW_NAME, MODEL_OBJECT_NAME, taskList);
	}
	
}
