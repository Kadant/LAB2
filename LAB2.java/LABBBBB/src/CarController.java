import Interfaces.IHaveRamp;
import Interfaces.IHaveTurbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarController {

    CarView frame;

    int gasAmount = 1;
    int brakeAmount = 1;

    public void inputButtons() {
        movementButtons();
        rampButtons();
        turboButtons();
        removeRandomCarButton();
        addRandomButton();
    }

    private void movementButtons() {
        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        viewable.getVehicle().stopEngine();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        viewable.getVehicle().startEngine();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        viewable.getVehicle().gas(gasAmount);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        viewable.getVehicle().brake(brakeAmount);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void turboButtons() {
        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        if (viewable.getVehicle() instanceof IHaveTurbo) {
                            ((IHaveTurbo) viewable.getVehicle()).setTurboOn();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        if (viewable.getVehicle() instanceof IHaveTurbo) {
                            ((IHaveTurbo) viewable.getVehicle()).setTurboOff();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    private void rampButtons() {
        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        if (viewable.getVehicle() instanceof IHaveRamp) {
                            ((IHaveRamp) viewable.getVehicle()).liftRamp();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (ViewableVehicles viewable : StorageViewables.viewables) {
                        if (viewable.getVehicle() instanceof IHaveRamp) {
                            ((IHaveRamp) viewable.getVehicle()).lowerRamp();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    private void addRandomButton () {
        frame.addRandomCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StorageViewables.addRandomViewable();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void removeRandomCarButton () {
        frame.removeRandomCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StorageViewables.removeRandomViewable();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}