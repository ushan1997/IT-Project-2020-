-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Sep 18, 2020 at 06:55 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `itproject1`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_username` varchar(255) NOT NULL,
  `admin_type` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE `exams` (
  `exam_id` int(11) NOT NULL,
  `exam_name` varchar(255) NOT NULL,
  `year` varchar(255) NOT NULL,
  `term` varchar(255) NOT NULL,
  `exam_class` int(11) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `exam_venue` varchar(255) NOT NULL,
  `deadline` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exams`
--

INSERT INTO `exams` (`exam_id`, `exam_name`, `year`, `term`, `exam_class`, `subject`, `teacher_name`, `exam_venue`, `deadline`) VALUES
(30, 'Grade 1 Maths', '2019', '2st Term', 10, 'Sinhala', 'ushan', 'Auditorium', '2013/01/9');

-- --------------------------------------------------------

--
-- Table structure for table `exam_marks`
--

CREATE TABLE `exam_marks` (
  `exam_marks_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `marks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exam_marks`
--

INSERT INTO `exam_marks` (`exam_marks_id`, `exam_id`, `student_id`, `marks`) VALUES
(41, 30, 1, 12);

-- --------------------------------------------------------

--
-- Table structure for table `exam_teacher`
--

CREATE TABLE `exam_teacher` (
  `exammarks_teacherid` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `extracurricular`
--

CREATE TABLE `extracurricular` (
  `extracurricular_id` int(11) NOT NULL,
  `activity_name` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `receipt_no` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `fees_year` int(11) NOT NULL,
  `fees_month` varchar(255) NOT NULL,
  `payment_date` date NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pricegiving_event`
--

CREATE TABLE `pricegiving_event` (
  `pevent_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `student_id` int(11) NOT NULL,
  `marks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sportmeet_event`
--

CREATE TABLE `sportmeet_event` (
  `event_id` int(11) NOT NULL,
  `exam_name` varchar(255) NOT NULL,
  `event_catogory` varchar(255) NOT NULL,
  `venue` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `teacher_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `class_of_admistion` varchar(255) NOT NULL,
  `date_of_admistion` varchar(255) NOT NULL,
  `contact_no` int(11) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `dob` int(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `student_name`, `class_of_admistion`, `date_of_admistion`, `contact_no`, `gender`, `dob`, `teacher_name`) VALUES
(1, 'ushan', 'grade1', 'adad', 11, 'ad', 211, 'ushan');

-- --------------------------------------------------------

--
-- Table structure for table `student_extracurricular`
--

CREATE TABLE `student_extracurricular` (
  `student_extracurricular_id` int(11) NOT NULL,
  `extracurricular_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `class` varchar(50) NOT NULL,
  `student_role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `student_sportmeet`
--

CREATE TABLE `student_sportmeet` (
  `student_sportmeet_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL,
  `subject_name` int(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `contact_no` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `teacher_name`, `address`, `dob`, `contact_no`, `email`, `password`) VALUES
(21, 'ushan', 'a', 'a', 11, 'a', 'q'),
(22, 'kalum', 'ad', 'ad', 12, 'ad', 'd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `teacher_id` (`teacher_name`);

--
-- Indexes for table `exams`
--
ALTER TABLE `exams`
  ADD PRIMARY KEY (`exam_id`),
  ADD KEY `teacher_id` (`teacher_name`);

--
-- Indexes for table `exam_marks`
--
ALTER TABLE `exam_marks`
  ADD PRIMARY KEY (`exam_marks_id`),
  ADD KEY `exam_id` (`exam_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `extracurricular`
--
ALTER TABLE `extracurricular`
  ADD PRIMARY KEY (`extracurricular_id`),
  ADD KEY `teacher_id` (`teacher_name`);

--
-- Indexes for table `fees`
--
ALTER TABLE `fees`
  ADD PRIMARY KEY (`receipt_no`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `pricegiving_event`
--
ALTER TABLE `pricegiving_event`
  ADD PRIMARY KEY (`pevent_id`);

--
-- Indexes for table `sportmeet_event`
--
ALTER TABLE `sportmeet_event`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `teacher_id` (`teacher_name`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `teacher_id` (`teacher_name`);

--
-- Indexes for table `student_extracurricular`
--
ALTER TABLE `student_extracurricular`
  ADD PRIMARY KEY (`student_extracurricular_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `extracurricular_id` (`extracurricular_id`);

--
-- Indexes for table `student_sportmeet`
--
ALTER TABLE `student_sportmeet`
  ADD PRIMARY KEY (`student_sportmeet_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`),
  ADD UNIQUE KEY `teacher_name` (`teacher_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exams`
--
ALTER TABLE `exams`
  MODIFY `exam_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `exam_marks`
--
ALTER TABLE `exam_marks`
  MODIFY `exam_marks_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `extracurricular`
--
ALTER TABLE `extracurricular`
  MODIFY `extracurricular_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `fees`
--
ALTER TABLE `fees`
  MODIFY `receipt_no` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sportmeet_event`
--
ALTER TABLE `sportmeet_event`
  MODIFY `event_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student_sportmeet`
--
ALTER TABLE `student_sportmeet`
  MODIFY `student_sportmeet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`teacher_name`) REFERENCES `teacher` (`teacher_name`);

--
-- Constraints for table `exam_marks`
--
ALTER TABLE `exam_marks`
  ADD CONSTRAINT `exam_marks_ibfk_4` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `exam_marks_ibfk_5` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `extracurricular`
--
ALTER TABLE `extracurricular`
  ADD CONSTRAINT `extracurricular_ibfk_1` FOREIGN KEY (`teacher_name`) REFERENCES `teacher` (`teacher_name`);

--
-- Constraints for table `fees`
--
ALTER TABLE `fees`
  ADD CONSTRAINT `fees_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

--
-- Constraints for table `sportmeet_event`
--
ALTER TABLE `sportmeet_event`
  ADD CONSTRAINT `sportmeet_event_ibfk_1` FOREIGN KEY (`teacher_name`) REFERENCES `teacher` (`teacher_name`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`teacher_name`) REFERENCES `teacher` (`teacher_name`);

--
-- Constraints for table `student_extracurricular`
--
ALTER TABLE `student_extracurricular`
  ADD CONSTRAINT `student_extracurricular_ibfk_1` FOREIGN KEY (`extracurricular_id`) REFERENCES `extracurricular` (`extracurricular_id`),
  ADD CONSTRAINT `student_extracurricular_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

--
-- Constraints for table `student_sportmeet`
--
ALTER TABLE `student_sportmeet`
  ADD CONSTRAINT `student_sportmeet_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `student_sportmeet_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `sportmeet_event` (`event_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
