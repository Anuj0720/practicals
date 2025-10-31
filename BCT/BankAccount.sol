// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {
    uint public balance;

    // Deposit function
    function deposit() public payable {  // <-- 'payable' is VERY important
        balance += msg.value;
    }

    // Withdraw function
    function withdraw(uint amount) public {
        require(balance >= amount, "Insufficient balance");
        balance -= amount;
        payable(msg.sender).transfer(amount);
    }

    // Check balance
    function getBalance() public view returns (uint) {
        return balance;
    }
}
