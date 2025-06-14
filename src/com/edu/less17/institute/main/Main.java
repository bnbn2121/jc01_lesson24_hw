package com.edu.less17.institute.main;

import java.util.ArrayList;
import java.util.List;

import com.edu.less17.institute.controller.ControllerByString;
import com.edu.less17.institute.model.Administrator;
import com.edu.less17.institute.model.CourseMember;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.Teacher;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceException;
import com.edu.less17.institute.service.ServiceProvider;
import com.edu.less17.institute.ui.ConsoleUI;
import com.edu.less17.institute.util.CourseParser;

public class Main {

	public static void main(String[] args) throws ServiceException {

		List<CourseMember> courseMembers = new ArrayList<>();
		
		// создаем персонал
		courseMembers.add(new Teacher("Виктор Олегович", "История"));
		courseMembers.add(new Administrator("Олег Олегович"));

		// создаем студентов
		courseMembers.add(new Student("Игорь", "РН-09-3"));
		courseMembers.add(new Student("Роман", "НД-09-1"));
		courseMembers.add(new Student("Алина", "РН-09-3"));
		courseMembers.add(new Student("Степан", "РН-09-4"));
		courseMembers.add(new Student("Валерий", "НД-09-1"));

		// создаем курс
		TrainingCourse course1 = new TrainingCourse();
		course1.setId(1);
		course1.setSpecialization("История");
		course1.setCourseMembers(courseMembers);

		// создаем репозиторий, сервис и контроллер
		Service service = ServiceProvider.getService();

		// записываем данные о курсе в файл
		service.saveCourse(course1);
		service.saveCourse(course1);

		// читаем данные курса из файла
		TrainingCourse course2 = service.getCourseById(1);

		// проводим изменение данных в курсе
		course2.setId(3);
		course2.addStudent(new Student("Анна", "НД-09-1"));

		// обфусцируем данные студента
		Student student = (Student) course2.getListeners().get(1);
		student.obfuscateName();

		// добавляем второй курс в файл
		service.saveCourse(course2);
		service.saveCourse(course2);
		service.saveCourse(course2);

		// удаляем первый курс из файла
		service.removeCourseById(1);

		// проводим урок
		System.out.println("Проводим урок:");
		service.conductLesson(3);
		System.out.println();

		// Выводим информацию в консоль
		System.out.println("Информация о курсе1:");
		System.out.println(service.getCourseInfo(course1));

		System.out.println("Информация о курсе2:");
		System.out.println(service.getCourseInfo(service.getCourseById(3)));

		System.out.println("Сортировка студентов по алфавиту:");
		System.out.println(CourseParser.getStringStudents(service.getStudentsByAlphabet(course2)));

		System.out.println("Сортировка студентов по среднему баллу:");
		System.out.println(CourseParser.getStringStudents(service.getStudentsByAverageGrade(course2)));

		// добавляю курс 4 для теста нового контроллера
		TrainingCourse course4 = service.getCourseById(3);
		course4.setId(4);
		service.saveCourse(course4);

		// пробую новый контроллер
		ControllerByString newController = new ControllerByString();
		System.out.println(newController.doAction("removecoursebyid\n3"));
		System.out.println(newController.doAction("conductlesson\n4"));
		System.out.println();
		System.out.println(newController.doAction("getcourses"));

		ConsoleUI console = ConsoleUI.getConsoleUI();
		console.start();

	}

}
