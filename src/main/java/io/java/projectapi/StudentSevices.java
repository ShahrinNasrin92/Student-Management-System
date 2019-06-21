package io.java.projectapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSevices {

	@Autowired
	private StudentRepository strepo;

	public List<Student> listAll() {
		return strepo.findAll();
	}

	public void save(Student student) {
		strepo.save(student);
	}

	public Student get(int Id) {
		return strepo.findById(Id).get();

	}

	public void delete(int Id) {
		strepo.deleteById(Id);
	}

}
