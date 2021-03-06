import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CarcontrolService } from '../shared/Carcontrol/carcontrol.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-carcontrol',
  templateUrl: './carcontrol.component.html',
  styleUrls: ['./carcontrol.component.css']
})
export class CarcontrolComponent implements OnInit {

  info : Array<any>
  idcarcontrol : Array<any>
  time : Array<any>
  timeout : Array<any>//
  annotation : Array<any>
  votepoint : Array<any>//
  stype : Array<any>
  nameprovinces : Array<any>

  select: any = {
    name : '',
    telephone : '',
    idcarcontrol : '',
    time : '',
    timeout :'',//
    annotation : '',
    votepoint : '',//
    stype : '',
    nameprovince : ''
  }

  constructor(private router:Router, private carcontrolService: CarcontrolService,private http: HttpClient) { }

  ngOnInit() {
    this.carcontrolService.getCarInformation().subscribe(data => {
      this.info = data;
      console.log(this.info);
    });

    this.carcontrolService.getCarStatus().subscribe(data => {
      this.stype = data;
      console.log(this.stype);
    });

    this.carcontrolService.getProvince().subscribe(data => {
      this.nameprovinces = data;
      console.log(this.nameprovinces);
    });
  }

  save() {
    if (this.select.name == null || this.select.name == '') {
      alert('กรุณาเลือกชื่อ');
    }
    else if (this.select.telephone == null || this.select.telephone == '') {
      alert('กรุณาเลือกเบอร์โทร');
    }
    else if (this.select.idcarcontrol == null || this.select.idcarcontrol == '') {
      alert('กรุณากรอกเลขที่ใบคุมรถ');
    }//
    else if (this.select.time == null || this.select.time == '') {
      alert('กรุณาเลือกวันที่');
    }
    else if (this.select.timeout == null || this.select.timeout == '') {
      alert('กรุณาเลือกวันที่กลับ');//
    }

    else if (this.select.annotation == null || this.select.annotation == '') {
      alert('กรุณากรอก *หมายเหตุ*');
    }
    else if (this.select.votepoint == null || this.select.votepoint == '') {
      alert('กรุณากรอก *ความพึงพอใจ1-4*');
    }//
    else if (this.select.stype == null || this.select.stype == '') {
      alert('กรุณาเลือกสเตตัส');
    }
    else if (this.select.nameprovince == null || this.select.nameprovince == '') {
      alert('กรุณาเลือกจังหวัด');
    } else {
      console.log(this.select.name);
      console.log(this.select.telephone);
      console.log(this.select.idcarcontrol);
      console.log(this.select.time);
      console.log(this.select.timeout);
      console.log(this.select.annotation);
      console.log(this.select.votepoint);
       console.log(this.select.stype);
       console.log(this.select.nameprovince);

    this.http.post('http://localhost:8080/carcontrols/' + this.select.name + '/' + this.select.idcarcontrol + '/' + this.select.time + '/' + this.select.timeout + '/' + this.select.annotation + '/'  + this.select.votepoint +  '/' + this.select.stype + '/' + this.select.nameprovince,this.select)
    .subscribe(
        data => {
            console.log('PUT Request is successful', data);
            alert("บันทึกสำเร็จ !!");
        },
        error => {
            console.log('Error to PUT Request', error);
            alert("FAIL");
        }
    );
  }
}
}

