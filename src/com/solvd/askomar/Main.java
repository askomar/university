package com.solvd.askomar;

import com.solvd.askomar.university.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    City[] cities = new City[3];
    cities[0] = new City("Minsk");
    cities[1] = new City("Pinsk");
    cities[2] = new City("Brest");

    Subject[] subjects = new Subject[5];
    subjects[0] = new Subject("Mathematics");
    subjects[1] = new Subject("Russian Language");
    subjects[2] = new Subject("Belarussian Language");
    subjects[3] = new Subject("History");
    subjects[4] = new Subject("Informatics");

    Department[] departments = new Department[2];

    Specialization[] specializations = new Specialization[6];
    specializations[0] =
        new Specialization("Automation of technological processes and productions");
    specializations[1] = new Specialization("Intelligent devices, machines and production");
    specializations[2] = new Specialization("Computer mechatronics");
    specializations[3] = new Specialization("Design and operation of nuclear power plants");
    specializations[4] = new Specialization("Industrial thermal power engineering");
    specializations[5] = new Specialization("Relay protection sand automation");

    departments[0] =
        new Department(
            "Automative",
            new Specialization[] {specializations[0], specializations[1], specializations[2]});
    departments[1] =
        new Department(
            "Mechanical Engineering",
            new Specialization[] {specializations[3], specializations[4], specializations[5]});

    University university =
        new University("Garvard", new Date("03/04/1988"), cities[0], departments);

    SpecializationPlan[] specializationPlans = new SpecializationPlan[specializations.length];
    specializationPlans[0] = new FullTimeSpecializationPlan(specializations[0], 10, 200);
    specializationPlans[1] = new FullTimeSpecializationPlan(specializations[1], 20, 140);
    specializationPlans[2] = new FullTimeSpecializationPlan(specializations[2], 40, 230);
    specializationPlans[3] = new FullTimeSpecializationPlan(specializations[3], 20, 240);
    specializationPlans[4] =
        new FullTimeSpecializationPlan(specializations[4], 15, 3000.21, 54, 300);
    specializationPlans[5] = new DistanceSpecializationPlan(specializations[5], 50, 433.99);

    Certificate[] certificates = new Certificate[4];
    certificates[0] = new CentralizeTestingCertificate(2307342, subjects[0], 70);
    certificates[1] = new CentralizeTestingCertificate(35225, subjects[1], 40);
    certificates[2] = new CentralizeTestingCertificate(8492, subjects[4], 55);
    certificates[3] = new HighSchoolCertificate(5902, 7);

    EmployeePosition employeePosition = new EmployeePosition("Manager");

    Person employee = new Employee("Kamarouski", "Andrei", "Sergeevich", employeePosition);

    Entrant entrant = new Entrant("Kamarouski", "Andrei", "Sergeevich", LocalDate.of(1998, 4, 27));

    EntrantForm bachelorEntrantForm =
        new BachelorEntrantForm(entrant, specializations[0], true, certificates);

    EntrantForm masterEntrantForm =
        new MasterEntrantForm(
            entrant,
            specializationPlans[2],
            false,
            (Employee) employee,
            specializations[1],
            LocalDate.of(2020, 6, 30));

    EnrollmentService enrollmentService = new EnrollmentService(specializationPlans);

    System.out.println("Available specialisations:");
    System.out.println(Arrays.toString(enrollmentService.getAvailableSpecialisations("distance")));

    Person dekan = new Employee("Kolesnikov", "Mikhail", new EmployeePosition("Dekan"));
    Person abiturient = new Entrant("Pupkin", "Vasya", LocalDate.of(1999, 5, 26));

    // Polymorphism
    System.out.println("\n##### example of the operation of the control class #####");
    System.out.println(InformationCommiteeService.getEducationIntstituteInfo(university));
    System.out.println(
        InformationCommiteeService.getSpecializationPlanInfo(specializationPlans[3]));
    System.out.println(InformationCommiteeService.getPersonShortName(employee));
  }
}
