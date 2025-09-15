# SyncSpace - File Sharing System

Aims to allow users to upload files to a shared S3 bucket to accomplish common tasks for students like sharing notes, and collaborating on assignments for easy retrieval and access.

---

<div style="display: flex; gap: 20px; align-items: flex-start; margin: 20px 0;">
  <div style="flex: 1;">
    <img src="https://github.com/user-attachments/assets/12c1586b-6d3d-4d5e-9532-fa271a2d0b83" alt="SyncSpace Architecture Diagram" style="width: 100%; max-width: 600px; height: auto;" />
  </div>
</div>

## Architecture Components

### 1. Simple Queue Service (SQS)
The entry point for file operations in SyncSpace. When users upload, share, or modify files, these requests are queued in SQS to reliably handle high velocity. This makes the user interface separate from the backend processing, allowing the system to handle multiple concurrent operations without overwhelming downstream services.

### 2. S3 Connection Management
This component manages the secure connection and authentication to the S3 storage bucket. It handles AWS credentials, permissions, and API calls to S3, acting as the gateway between the application logic and the actual file storage. This layer ensures that all S3 operations are properly authenticated and follow secure practices.

### 3. Amazon EC2 (Containerized Processing)
The core processing engine of SyncSpace running on EC2 instances. These servers run Docker containers that handle file operations like uploading, downloading, sharing, and synchronization. The containerized approach allows for scalable deployment and consistent environments across different instances and operating systems, processing the queued requests from SQS.

### 4. Database Management (Amazon RDS)
This component manages the database operations, storing file metadata, user information, sharing permissions, and folder structures in Amazon RDS. While the actual files are stored in S3, RDS maintains the relational data that tracks file ownership, sharing settings, version history, and user access rights. Acts as a manager to verify the user has the correct set of actions available to them.

### 5. User Role Management (App Config)
The authorization and configuration management system that defines user permissions and application settings. This component determines what actions each user can perform (view, edit, share, delete), manages team permissions, and configures application behavior. It works dynamically to adjust user access levels and feature availability without requiring full application restarts.

---

## Tech Stack

### Backend
- **Spring Boot 3** - Core framework
- **Spring Data JPA** - For working with the user database
- **Spring Security 6** - Authentication and authorization with roles
- **PostgreSQL** - Primary database management system
- **Docker** - Containerization for deployment and opening of files across devices

### Frontend
- **React** - Base framework for the FE
- **JavaScript/TypeScript**
- **Angular** - More dynamic components

### Cloud & DevOps
- **AWS (S3, EC2, RDS, SQS)** - Cloud infrastructure and services
- **Docker** - Containerization for scalable deployment
- **DevOps Best Practices** - CI/CD pipeline using YAML

---

## Key Features

- **Secure File Sharing** - Role-based access control with Spring Security
- **Scalable Architecture** - Queue-based processing with SQS
- **Cloud Storage** - Reliable file storage with AWS S3
- **Real-time Collaboration** - Dynamic UI updates with Angular/React
- **Containerized Deployment** - Docker-based scalability
- **Student-Focused** - Optimized for academic collaboration and note sharing
