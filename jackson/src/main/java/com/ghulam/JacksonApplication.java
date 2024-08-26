package com.ghulam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class JacksonApplication {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(JacksonApplication.class, args);

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		String ans = mapper.writeValueAsString(map);
//		System.out.println(ans);

		Employee employee = new Employee(23L, "John", "Doe", 23000);
		String str = mapper.writeValueAsString(employee);
//		System.out.println(str);

		String data = "{\"id\":23,\"name\":\"John\",\"address\":\"Doe\",\"salary\":23000}";
		Object object = mapper.readValue(data, Employee.class);
//		System.out.println(object.toString());

		Solver solver = new Solver();
		String source = solver.readFile();
		solver.traverse(source);
	}
}

@Slf4j
class Solver {

	private final ObjectMapper mapper = new ObjectMapper();

	String readFile() {
		Path filePath = Paths.get("src/main/resources/static/filename.json");
		log.info("{}", filePath);

        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(bytes);
	}

	void traverse(String source) {
		JsonNode node = null;
		try {
			node = mapper.readTree(source);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// logic to traverse
	}
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Employee {
	private Long id;
	private String name;
	private String address;
	private int salary;
}