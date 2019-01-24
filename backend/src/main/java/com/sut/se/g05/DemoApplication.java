package com.sut.se.g05;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.stream.Stream;


@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(GenderRepository genderRepository, ProvinceRepository provinceRepository,
						   LinkRepository linkRepository, SenderRepository senderRepository,
						   ReceiverRepository receiverRepository, ProvincesenRepository provincesenRepository, RepairinfoRepository repairinfoRepository,
						   DamageRepository damageRepository,
						   DriverRepository driverRepository,
						   CarInformationRepository carInformationRepository,
						   CarRepository carRepository) {
		return args -> {
			Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี","ชัยนาท"
					,"ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช"
					,"นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา"
					,"พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พะเยา","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน"
					,"ยะลา","ยโสธร","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา","สตูล"
					,"สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี","สุรินทร์","หนองคาย"
					,"หนองบัวลำภู","อ่างทอง","อุดรธานี","อุทัยธานี","อุตรดิตถ์","อุบลราชธานี","อำนาจเจริญ").forEach(provinces -> {
				Province p = new Province();
				p.setProvince(provinces);
				provinceRepository.save(p);

				Provincesen ps = new Provincesen();
				ps.setProvincesen(provinces);
				provincesenRepository.save(ps);

			});

			Stream.of("หม้อน้ำเสื่อมสภาพ","ยางรถยนตร์เสื่อมสภาพ","เครื่องยนตร์เสื่อมสภาพ","อุบัติเหตุทางรถยนตร์").forEach(damageName -> {
				Damage damage = new Damage();
				damage.setDamageName(damageName);
				damageRepository.save(damage);
			});

			Stream.of("สมชาย","สมหญิง","สมหมาย","สมศรี").forEach(driverName -> {
				Driver driver = new Driver();
				driver.setDriverName(driverName);
				driverRepository.save(driver);
			});

			Gender g = new Gender();
			g.setGender("ชาย");
			Gender g2 = new Gender();
			g2.setGender("หญิง");
			genderRepository.save(g);
			genderRepository.save(g2);

			Sender s = new Sender();
			s.setFirstnamesen("แพรวโพยม");
			s.setLastnamesen("สอนสุภาพ");
			s.setAddresssen("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
			s.setPostcodesen("65180");
			s.setPhonesen("0956399315");
			s.setEmail("ice@gmail.com");
			s.setPassword("123");

			Receiver r = new Receiver();
			r.setFirstnamerec("แพรวโพยม");
			r.setLastnamerec("สอนสุภาพ");
			r.setAddressrec("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
			r.setPostcoderec("65180");
			r.setPhonerec("0956399315");

			Gender gender = genderRepository.findBygender("ชาย");
			Gender gender2 = genderRepository.findBygender("หญิง");
			s.setGender(gender);
			s.setGender(gender2);

			Province province = provinceRepository.findByprovince("พิษณุโลก");
			r.setProvince(province);
			Provincesen provincesen = provincesenRepository.findByprovincesen("พิษณุโลก");
			s.setProvincesen(provincesen);


			senderRepository.save(s);
			senderRepository.findAll().forEach(System.out::println);
			receiverRepository.save(r);
			receiverRepository.findAll().forEach(System.out::println);

			damageRepository.findAll().forEach(System.out::println);
			driverRepository.findAll().forEach(System.out::println);


/*tanz*/

			Car c1 = new Car();
			c1.setCarbrand("รถยนต์กะบะ");
			c1.setlicenseplate("กก-99");
			Car c2 = new Car();
			c2.setCarbrand("สิบล้อ");
			c2.setlicenseplate("กก-999");
			Car c3 = new Car();
			c3.setCarbrand("รถพ่วง");
			c3.setlicenseplate("กก-9999");

			carRepository.save(c1);
			carRepository.save(c2);
			carRepository.save(c3);

			CarInformation c = new CarInformation();
			c.setName("tanz benjamas");
			c.setAddress("suranaree");
			c.setTelephone("0988313467");
			c.setAge(22);
			c.setCarbrand(c3);

			carInformationRepository.save(c);

		};
	}
}