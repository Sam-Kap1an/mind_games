# Mind_Games

This repository contains information and resources for **Mind_Games**, a unique 2D platformer game that allows players to control the game using their mind. The game is designed to be played with an **Emotiv headset**, utilizing **EEG (Electroencephalogram)** functionality to detect brain activity and translate it into game controls.

## Features
- **Mind-Controlled Gameplay:** Play the game using your brainwaves through an Emotiv headset.
- **2D Platformer Mechanics:** Navigate through the world and use the power of your brain to control your player's jump height. The more engaged you are, the further your player will jump.
- **EEG Integration:** Seamless integration with Emotiv headsets for real-time brainwave detection and control.

## Prerequisites
- **Emotiv Headset** with EEG functionality, preferably Emotiv Insight.
- A compatible **computer** running the necessary Emotiv software to capture brain activity data.

## Emotiv Installation

1. Install the [Emotiv Launcher](https://www.emotiv.com/) to interface the device with your computer.
2. Follow this [Video](https://www.youtube.com/watch?v=vyvA2SQuF6w&list=PLeU2B0nZd2LTFT1XiCad6lWHyIVzZw7wr&index=13&ab_channel=EmotivAcademy) to install Node-Red and any dependencies
3. Launch Node Red and Visit: http://127.0.0.1:1880/
4. Ensure your node graph looks like this: ![image](https://github.com/user-attachments/assets/6272cd54-def8-4e08-9e67-22a640aef005) 
5. Configure MQTT Out Node: ![image](https://github.com/user-attachments/assets/b46c2d48-3497-4536-934e-2a283c063983)
6. Deploy workflow
7. This should publish live data through an MQTT broker

## Game Installation
1. Clone or download this repository to your local machine:
   ```bash
   git clone https://github.com/Sam-Kap1an/mind_games.git
2. Run Main(), the terminal should listen for data coming directly from your Emotiv headset
