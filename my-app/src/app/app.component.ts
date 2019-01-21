import { Component, OnInit } from '@angular/core';
import {STUDENTS} from './mock-student'
import { Student } from './student';
import { i18nEnd } from '@angular/core/src/render3';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  students=STUDENTS;
  id1:number; 
  name1:String;
  constructor(){}
  ngOnInit(){
  
}
 
  title = "Vinay's first App" ;
  selectedStudent:Student;
  onSelect(student: Student): void {
    this.selectedStudent=student;
  }
  removeStudent(student: Student): void {
    this.students.splice(this.students.indexOf(student), 1);

  }
  addStudent(): void {
    this.students.push({id:this.id1, name: this.name1});
    this.id1= 0; 
    this.name1='';

  }


}


