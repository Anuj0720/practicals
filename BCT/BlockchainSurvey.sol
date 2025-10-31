// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BlockchainSurvey {
    struct BlockchainType {
        string name;
        string description;
        string useCase;
    }

    BlockchainType[] public blockchains;

    // Add new blockchain type
    function addBlockchain(string memory _name, string memory _description, string memory _useCase) public {
        blockchains.push(BlockchainType(_name, _description, _useCase));
    }

    // Get blockchain details by index
    function getBlockchain(uint index) public view returns (string memory, string memory, string memory) {
        require(index < blockchains.length, "Invalid index");
        BlockchainType memory b = blockchains[index];
        return (b.name, b.description, b.useCase);
    }

    // Fallback function
    fallback() external payable {}
}
