# Mind_Games

This repository contains information and resources for **Mind_Games**, a unique 2D platformer game that allows players to control the game using their mind. The game is designed to be played with an **Emotiv headset**, utilizing **EEG (Electroencephalogram)** functionality to detect brain activity and translate it into game controls.

## Features
- **Mind-Controlled Gameplay:** Play the game using your brainwaves through an Emotiv headset.
- **2D Platformer Mechanics:** Navigate through the world and use the power of your brain to control your player's jump height. The more engaged you are, the further your player will jump.
- **EEG Integration:** Seamless integration with Emotiv headsets for real-time brainwave detection and control.

## Prerequisites
- **Emotiv Insight Headset** with EEG functionality
- A compatible **computer** running the necessary Emotiv software to capture brain activity data.

## Emotiv Installation

1. Install the [Emotiv Launcher](https://www.emotiv.com/) to interface the device with your computer.
2. Launch the Emotiv Launcher and connect the Insight to your computer. Ensure that the device is registered within the launcher.
3. Register an account with Emotiv and create an App. Note down the client secret and other application specific variables.
4. Follow this [Video](https://www.youtube.com/watch?v=vyvA2SQuF6w&list=PLeU2B0nZd2LTFT1XiCad6lWHyIVzZw7wr&index=13&ab_channel=EmotivAcademy) to install Node-Red and any dependencies
5. Launch Node Red and Visit: http://127.0.0.1:1880/
6. Ensure your node graph looks like this: ![image](https://github.com/user-attachments/assets/6272cd54-def8-4e08-9e67-22a640aef005) 
7. Configure MQTT Out Node: ![image](https://github.com/user-attachments/assets/b46c2d48-3497-4536-934e-2a283c063983)
8. Deploy workflow
9. This should publish live data through an MQTT broker

## Game Installation
1. Clone or download this repository to your local machine:
   ```bash
   git clone https://github.com/Sam-Kap1an/mind_games.git
2. Run Main(), the terminal should listen for data coming directly from your Emotiv headset
3. Alternative, double click the mind_games-1.0-SNAPSHOT.jar in the root directory.


## Tutorial
1. Please ensure you have Emotiv Launcher open, headset connected, and node-red running.
2. Once the game is launched, you must wait for a signal from the headset to set your jump strength.
3. Jump strength decays over time in between received signals.
4. Use A and D keys to strafe left or right mid-air to reach desired platform.
5. Use the bounce platform to maintain/increase vertical height.
6. Reach the last platform! Style points for jumping backwards back to the start.
