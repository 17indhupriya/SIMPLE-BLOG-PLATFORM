# Professional Blog Platform

A modern, feature-rich blog platform built with Spring Boot, Thymeleaf, and H2 Database. This application provides a complete blogging solution with a clean, professional interface and comprehensive blog management features.

## 🚀 Features

### Core Features
- ✅ **Create Posts** - Rich text editor for creating new blog posts
- ✅ **View Posts** - Clean, readable post display with full content
- ✅ **Edit Posts** - Update existing posts with ease
- ✅ **Delete Posts** - Remove unwanted posts with confirmation
- ✅ **Search Posts** - Search functionality across titles and content
- ✅ **Responsive Design** - Works perfectly on desktop, tablet, and mobile

### Advanced Features
- 📊 **View Counter** - Track post popularity with view counts
- 📝 **Post Excerpts** - Automatic excerpt generation for post previews
- 👤 **Author Management** - Post attribution with author names
- 🏷️ **Tags Support** - Organize posts with tags
- 📅 **Timestamps** - Created and updated timestamps for posts
- 🎨 **Professional UI** - Modern, clean design with smooth animations
- 📱 **Mobile Responsive** - Optimized for all device sizes
- 🖨️ **Print Support** - Print-friendly post layouts
- 🔗 **Share Functionality** - Easy post sharing capabilities

## 🛠️ Technologies Used

- **Backend**: Spring Boot 3.5.4
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript
- **Database**: H2 (in-memory for development)
- **Build Tool**: Maven
- **Java Version**: 17+
- **Validation**: Spring Boot Validation
- **ORM**: Spring Data JPA with Hibernate

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 17 or higher
- Maven 3.6 or higher
- Git (for version control)

## ⚡ Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/professional-blog-platform.git
cd professional-blog-platform
```

### 2. Build the Project
```bash
./mvnw clean compile
```

### 3. Run the Application
```bash
./mvnw spring-boot:run
```

### 4. Access the Application
Open your browser and navigate to:
- **Main Application**: http://localhost:8080
- **H2 Database Console**: http://localhost:8080/h2-console

## 🎯 Usage

### Creating a New Post
1. Click the "✍️ Create New Post" button on the homepage
2. Fill in the title and content
3. Click "Publish" to save your post

### Managing Posts
- **View**: Click on any post title or use the "👁️ View" button
- **Edit**: Use the "✏️ Edit" button on any post
- **Delete**: Use the "🗑️ Delete" button (with confirmation)

### Searching Posts
Use the search bar in the navigation to find posts by title or content.

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/blog/
│   │   ├── controller/     # Web controllers
│   │   ├── model/         # Entity classes
│   │   ├── repository/    # Data access layer
│   │   └── BlogApplication.java
│   └── resources/
│       ├── static/css/    # Stylesheets
│       ├── templates/     # Thymeleaf templates
│       ├── application.properties
│       └── data.sql       # Sample data
└── test/                  # Test files
```

## 🔧 Configuration

### Database Configuration
The application uses H2 in-memory database by default. Configuration in `application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=password

# H2 Console (for debugging)
spring.h2.console.enabled=true
```

### Custom Port
To run on a different port, add to `application.properties`:
```properties
server.port=8081
```

## 🚀 Deployment

### Building for Production
```bash
./mvnw clean package -DskipTests
java -jar target/blog-0.0.1-SNAPSHOT.jar
```

### Docker Deployment
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/blog-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

## 🧪 Testing

Run the test suite:
```bash
./mvnw test
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📸 Screenshots

### Homepage
![Homepage](docs/screenshots/homepage.png)

### Create Post
![Create Post](docs/screenshots/create-post.png)

### View Post
![View Post](docs/screenshots/view-post.png)

## 🐛 Known Issues

- None currently reported

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourprofile)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Thymeleaf team for the template engine
- All contributors who helped improve this project

## 📈 Future Enhancements

- [ ] User authentication and authorization
- [ ] Comment system
- [ ] Post categories
- [ ] Image upload functionality
- [ ] Rich text editor (WYSIWYG)
- [ ] Email notifications
- [ ] RSS feed generation
- [ ] Social media integration
- [ ] SEO optimization
- [ ] Post scheduling

---

⭐ **Star this repository if you found it helpful!**
