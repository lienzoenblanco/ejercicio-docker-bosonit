package com.example.ej2crud.infraestructure.controller;

import com.example.ej2crud.application.*;
import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.infraestructure.dto.input.InputStudentDto;
import com.example.ej2crud.infraestructure.dto.output.OutputStudentFullDto;
import com.example.ej2crud.infraestructure.dto.output.OutputStudentSimpleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired private AddStudentUseCase addStudentUseCase;
  @PostMapping
  public ResponseEntity add(@RequestBody InputStudentDto inputStudentDto) {
    ResponseDto responseDto = this.addStudentUseCase.add(inputStudentDto);
    if (!responseDto.getSuccess()) {
      return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity(responseDto, HttpStatus.CREATED);
  }

  @Autowired private ListStudentUseCase listStudentUseCase;
  @GetMapping
  public List<OutputStudentSimpleDto> list() {
    return this.listStudentUseCase.list();
  }

  @Autowired private ByIdStudentUseCase byIdStudentUseCase;
  @GetMapping("/{id}")
  public ResponseEntity getById(
      @PathVariable int id,
      @RequestParam(name = "outputType", required = false) String outputType) {
    if (outputType != null && outputType.equals("full")) {
      return new ResponseEntity(this.byIdStudentUseCase.getById(id), HttpStatus.OK);
    }
    OutputStudentFullDto outputFull = this.byIdStudentUseCase.getById(id);
    OutputStudentSimpleDto outputSimple = new OutputStudentSimpleDto();
    outputSimple.setStudent_id(outputFull.getStudent_id());
    outputSimple.setName(outputFull.getName());
    outputSimple.setNum_hours_week(outputFull.getNum_hours_week());
    outputSimple.setComments(outputFull.getComments());
    outputSimple.setBranch(outputFull.getBranch());
    return new ResponseEntity(outputSimple, HttpStatus.OK);
  }

  @Autowired private ByNameStudentUseCase byNameStudentUseCase;
  @GetMapping("/name/{name}")
  public ResponseEntity findByName(@PathVariable String name) {
    return new ResponseEntity(this.byNameStudentUseCase.findByName(name), HttpStatus.OK);
  }

  @Autowired private UpdateStudentUseCase updateStudentUseCase;
  @PutMapping("/{id}")
  public ResponseEntity update(@RequestBody InputStudentDto student, @PathVariable int id) {
    return new ResponseEntity<>(this.updateStudentUseCase, HttpStatus.ACCEPTED);
  }

  @Autowired private DeleteStudentUseCase deleteStudentUseCase;
  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {this.deleteStudentUseCase.delete(id);}
}