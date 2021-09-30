package com.parkingslot;

public class ParkingLotSystem {
    private Object vehicle;

    public ParkingLotSystem(){
    }

    public void park(Object vehicle) throws ParkingLotException{
        if (this.vehicle != null)
            throw new ParkingLotException("ParkingLot is full.");
        this.vehicle = vehicle;
    }

    public boolean unPark(Object vehicle) {
        if (vehicle == null)
            return false;
        if (this.vehicle.equals(vehicle)){
            this.vehicle = null;
            return true;
        }
        return false;
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public void isLotFull(Object vehicle) throws ParkingLotException {
        if (this.vehicle != null)
            throw new ParkingLotException("ParkingLot is full");
        this.vehicle = vehicle;
    }
}
