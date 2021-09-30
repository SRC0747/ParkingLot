package com.parkingslot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @BeforeEach
    public void setUp() throws Exception {
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem();
    }

    @Test
    public void givenAVehicle_WhenParked_ShouldReturnTrue(){
        try{
            parkingLotSystem.park(vehicle);
            boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
            Assertions.assertTrue(isParked);
        }catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        try{
            parkingLotSystem.park(vehicle);
            parkingLotSystem.park(new Object());
        }catch (ParkingLotException e){
            Assertions.assertEquals("ParkingLot is full.", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        try{
            parkingLotSystem.park(vehicle);
            boolean isUnParked = parkingLotSystem.unPark(vehicle);
            Assertions.assertTrue(isUnParked);
        }catch (ParkingLotException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenASignByPassingMessage_WhenParkingLotIsFull_ShouldReturnTrue() {
        try{
            parkingLotSystem.isLotFull(vehicle);
            parkingLotSystem.isLotFull(new Object());
        }catch (ParkingLotException e){
            Assertions.assertEquals("ParkingLot is full", e.getMessage());
            e.printStackTrace();
        }
    }
}