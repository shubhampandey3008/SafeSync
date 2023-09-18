# Safesync (Assisted Disaster Response Coordination System) :robot:

## Introduction :wave:
In the face of a disaster, efficient coordination among various stakeholders is crucial to minimize loss of life and cost. However, manual handling of this task is time-consuming, costly, and prone to human error. The challenge is exponentially increasing the coordination among these stakeholders to make the disaster response more seamless and efficient.
We propose an AI-Assisted Disaster Response Coordination System (AIDRCS) that leverages a central data store and a Large Language Model (LLM) with both short and long-term memory to facilitate real-time communication and stakeholder coordination.


## Features :rocket:

- **Putting AI as an Intermediary** :robot:
  - Our AI tool acts as a critical intermediary in disaster management.
  
- **Data Input from Stakeholders** :earth_americas:
  - The LLM (Large Language Model) is fed with real-time information and situations on the ground by concerned stakeholders.
  
- **Incident Analysis** :bar_chart:
  - The LLM comprehensively analyzes the incident, determining which stakeholders need to be informed about it.
  
- **Access to Central Databases** :floppy_disk:
  - Our application has access to the central databases of various authorities, enabling it to know the current availability of resources, such as hospitals with various medical assets.
  
- **Resource Calculation** :abacus:
  - Our model assesses the intensity of the incident and calculates the precise amount of resources needed from various authorities. For example, it may request ambulances from hospitals.
  
- **Resource Request and Approval** :inbox_tray: :white_check_mark:
  - The AI tool proactively contacts the concerned authorities, sending resource requests and waiting for their approval.
  
- **Smart Resource Allocation** :bulb:
  - In cases where a single stakeholder cannot fulfill all the requirements, the model intelligently allocates requests to multiple stakeholders, ensuring efficient resource allocation.
  
- **Collaboration with NGOs** :handshake:
  - The AI tool actively collaborates with non-governmental organizations (NGOs) to enhance disaster response and relief efforts.

These features highlight how our smart disaster management assistant AI tool streamlines communication, optimizes resource allocation, and collaborates with various stakeholders to ensure effective disaster response and management.

## Getting Started :computer:

### LLM Backend:

1. **Install Requirements** :gear::
   - Install the necessary Python packages from the `requirements.txt` file in the current environment, preferably a virtual environment. Use the command:
     ```
     python -m pip install -r requirements.txt
     ```

2. **Run IPython Notebook** :running::
   - Run the provided IPython Notebook (`.ipynb` file) in the desired port.

### SpringBoot Backend:

1. **Maven Clean Install** :wrench::
   - Navigate to the directory containing the `.mvn` file for the SpringBoot backend.
   - Execute a Maven clean install using the following command:
     ```
     mvn clean install
     ```

2. **Note on Port Configuration** :information_source::
   - Ensure that the port configurations for both the SpringBoot backend and LLM backend are the same, as SpringBoot will be hitting the LLM backend API.

### React Frontend:

1. **Install Node Modules** :package::
   - Navigate to the React Frontend directory.
   - Install the necessary Node.js modules using the command:
     ```
     npm install
     ```

2. **Start the Application** :rocket::
   - Start the React application using the command:
     ```
     npm start
     ```

These steps will guide you through setting up and running the LLM Backend, SpringBoot Backend, and React Frontend of the Smart Disaster Management Assistant AI Tool.


## Usage :bulb:

![Image Alt Text](https://github.com/shubhampandey3008/SafeSync/blob/main/ss/WorkingGraph.png)


- **Multiple Frontend Instances for Stakeholders** :earth_americas:
  - We have different instances of the frontend, each representing different stakeholders involved in disaster management.

- **Raising an Alarm** :rotating_light:
  - Any stakeholder can raise an alarm about a possible incident using their respective frontend instance.

- **Natural Language Incident Description** :speaking_head:
  - Stakeholders can describe the situation in natural human language, preferably English. They provide a detailed description of the incident.

- **Model Processing** :robot::gear::
  - After receiving the incident description, our AI model processes the information.

- **Resource Request** :inbox_tray:
  - The model determines the necessary resources and sends a resource request to the chosen stakeholder.

- **Message Displayed in Frontend** :computer::
  - The resource request message is displayed in the respective stakeholder's frontend instance.

- **Effective Emergency Response** :ambulance:
  - Stakeholders can take immediate actions to tackle the emergency based on the information provided in the message.

This user-friendly process allows stakeholders to quickly report incidents, and our AI tool facilitates efficient resource allocation and communication to ensure an effective emergency response.
