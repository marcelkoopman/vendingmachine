package github.com.marcelkoopman.vendingmachine;


import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineFiller;
import github.com.marcelkoopman.vendingmachine.vendingmachine.VendingMachineV1;
import github.com.marcelkoopman.vendingmachine.vendingmachine.prices.EuroRegionPrices;
import github.com.marcelkoopman.vendingmachine.vendingmachine.terminal.VendingMachineTerminal;

/**
 * Main app to boot the vending machine
 */
public class Main {


    public static void main(String[] args) {

        var vendingMachine = new VendingMachineV1(new EuroRegionPrices());
        var filler = new VendingMachineFiller();
        var terminal = new VendingMachineTerminal(vendingMachine, filler);

        vendingMachine.boot();
        terminal.boot();
        vendingMachine.shutDown();
    }
}
