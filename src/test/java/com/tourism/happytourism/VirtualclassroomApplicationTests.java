package com.solugenix.Virtualclassroom;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class HappyTourismApplicationTests {
//
//	@Autowired
//	private AdminServiceMgmtImpl adminService;
//
//	 @MockBean
//	private AdminRepo adminRepo;
//
//     @MockBean
//	 private FacultySignupRepo facultyRepo;
//
//	 @MockBean
//	 private StudentSignupRepo signupRepo;
//
//	 @MockBean
//	 private CredentialsEntityRepo credentialsRepo;
//
//	@Test
//    public void fetchAllAdminTest() throws ResourceNotFoundException {
//		AdminEntity admin1 = new AdminEntity();
//		admin1.setId(111L);
//		admin1.setName("Vikas");
//		admin1.setUsername("vikas123@gmail.com");
//		admin1.setPassword("Vikas@12345");
//		admin1.setAge(23);
//		admin1.setMobileNo("9834717134");
//		admin1.setEmail("vikasjadhav4569@gmail.com");
//		admin1.setCreatedDate(new Date());
//
//		AdminEntity admin2 = new AdminEntity();
//		admin2.setId(222L);
//		admin2.setName("Raja");
//		admin2.setUsername("raja@gmail.com");
//		admin2.setPassword("Vikas@182562");
//		admin2.setAge(39);
//		admin2.setMobileNo("9834717134");
//		admin2.setEmail("vikas@solugenix.com");
//		admin2.setCreatedDate(new Date());
//
//
//		 when(adminRepo.findAll()).thenReturn(Stream
//				 .of(admin1,admin2).collect(Collectors.toList()));
//
//		 assertEquals(2,adminService.fetchAllAdmin().size());
//	}
//
//	@Test
//	public void fetchAllfacultyTest(){
//		FacultySignUpEntity faculty1= new FacultySignUpEntity();
//				faculty1.setId(123L);
//				faculty1.setName("patil");
//				faculty1.setAge(50);
//				faculty1.setEmail("vj@gmail.com");
//				faculty1.setSubject("java");
//				faculty1.setMobileNo("123456");
//				faculty1.setDeptno("20");
//
//		FacultySignUpEntity faculty2= new FacultySignUpEntity();
//			faculty2.setId(123L);
//			faculty2.setName("patil");
//			faculty2.setAge(50);
//			faculty2.setEmail("vj@gmail.com");
//			faculty2.setSubject("java");
//			faculty2.setMobileNo("123456");
//			faculty2.setDeptno("20");
//
//			when(facultyRepo.findAll()).thenReturn(Stream.of(faculty1,faculty2).collect(Collectors.toList()));
//            assertEquals(2,facultyRepo.findAll().size());
//	}
//
//	@Test
//	public void fetchAllStudentsTest() throws ResourceNotFoundException {
//		StudentSignupEntity  student1= new StudentSignupEntity();
//		         student1.setId(22L);
//				 student1.setName("rajesh");
//				 student1.setAge(23);
//				 student1.setEmail("rajesh@gmail.com");
//				 student1.setPassword("Rajesh@1234");
//
//		StudentSignupEntity  student2= new StudentSignupEntity();
//		  	student2.setId(32L);
//			student2.setName("mangesh");
//			student2.setAge(25);
//			student2.setEmail("mang@gmail.com");
//		    student2.setPassword("Mang@1234");
//
//         when(signupRepo.findAll()).thenReturn(Stream.of(student1,student2).collect(Collectors.toList()));
//		 assertEquals(2,adminService.fetchAllStudents().size());
//	}
//
//	@Test
//	public  void updateAdminTest(){
////		AdminEntity admin1 = new AdminEntity();
////		admin1.setId(123L);
////		admin1.setName("Akash");
////		admin1.setUsername("vikas123@gmail.com");
////		admin1.setPassword("Akash@12345");
////		admin1.setAge(26);
////		admin1.setMobileNo("9834717134");
////		admin1.setEmail("jadhav4569@gmail.com");
//
//		AdminEntity admin2 = new AdminEntity();
//		admin2.setId(123L);
//		admin2.setName("Laxman");
//		admin2.setUsername("luc123@gmail.com");
//		admin2.setPassword("laxman@12345");
//		admin2.setAge(29);
//		admin2.setMobileNo("9834717134");
//		admin2.setEmail("lucky4569@gmail.com");
//
//        when(adminRepo.save(admin2)).thenReturn(admin2);
//		assertEquals(admin2,adminService.updateAdmin(admin2));
//
//	}
//
//	@Test
//	public void deleteAccCredentialsTest(){
//		long id=101L;
//		adminService.deleteAccCredentials(id);
//		verify(credentialsRepo,times(1)).deleteByAccId(id);
//	}
//
//	@Test
//	public void createAdminTest(){
//		AdminEntity admin1 = new AdminEntity();
//		admin1.setId(123L);
//		admin1.setName("Akash");
//		admin1.setUsername("vikas123@gmail.com");
//		admin1.setPassword("Akash@12345");
//		admin1.setAge(26);
//		admin1.setMobileNo("9834717134");
//		admin1.setEmail("jadhav4569@gmail.com");
//
//		when(adminRepo.save(admin1)).thenReturn(admin1);
//
//		assertEquals(admin1,adminService.createAdmin(admin1));
//	}
//
//	@Test
//	public void deleteAccountByIdRoleTest() throws ResourceNotFoundException {
//		AdminEntity admin1 = new AdminEntity();
//		admin1.setId(123L);
//		admin1.setName("Akash");
//		admin1.setUsername("vikas123@gmail.com");
//		admin1.setPassword("Akash@12345");
//		admin1.setAge(26);
//		admin1.setMobileNo("9834717134");
//		admin1.setEmail("jadhav4569@gmail.com");
//
//		Long id=123L;
//		String role="admin";
//
//		when(adminService.deleteAccountByIdRole(id,role)).thenReturn(true);
//	    assertTrue(adminService.deleteAccountByIdRole(id,role));
//
//	}
}
