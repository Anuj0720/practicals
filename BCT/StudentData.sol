// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {
    struct Student {
        uint id;
        string name;
        uint age;
    }

    Student[] public students;

    function addStudent(uint _id, string memory _name, uint _age) public {
        students.push(Student(_id, _name, _age));
    }

    function getStudent(uint index) public view returns (uint, string memory, uint) {
        Student memory s = students[index];
        return (s.id, s.name, s.age);
    }

    // Fallback function
    fallback() external payable {}

    // Optional: to receive ether
    receive() external payable {}
}
