USE [master]
GO
/****** Object:  Database [spring_security_demo_encrypted]    Script Date: 4/4/2021 2:20:07 PM ******/
CREATE DATABASE [spring_security_demo_encrypted]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'spring_security_demo_encrypted', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\spring_security_demo_encrypted.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'spring_security_demo_encrypted_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\spring_security_demo_encrypted_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [spring_security_demo_encrypted] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [spring_security_demo_encrypted].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [spring_security_demo_encrypted] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET ARITHABORT OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET  DISABLE_BROKER 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET RECOVERY FULL 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET  MULTI_USER 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [spring_security_demo_encrypted] SET DB_CHAINING OFF 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [spring_security_demo_encrypted] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'spring_security_demo_encrypted', N'ON'
GO
USE [spring_security_demo_encrypted]
GO
/****** Object:  User [springstudent]    Script Date: 4/4/2021 2:20:07 PM ******/
CREATE USER [springstudent] FOR LOGIN [springstudent] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [springstudent]
GO
ALTER ROLE [db_datareader] ADD MEMBER [springstudent]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [springstudent]
GO
/****** Object:  Table [dbo].[authorities]    Script Date: 4/4/2021 2:20:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[authorities](
	[username] [varchar](50) NULL,
	[authority] [varchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users]    Script Date: 4/4/2021 2:20:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](68) NULL,
	[enabled] [tinyint] NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'john', N'ROLE_EMPLOYEE')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'mary', N'ROLE_EMPLOYEE')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'mary', N'ROLE_MANAGER')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'susan', N'ROLE_EMPLOYEE')
INSERT [dbo].[authorities] ([username], [authority]) VALUES (N'susan', N'ROLE_ADMIN')
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'john', N'{bcrypt}$2a$10$12tNGY/2mOywEOYufGcLnuICjFl/Z3F/FWl4UAq2zcqUwZbFm/mdW', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'mary', N'{bcrypt}$2a$10$9bWMlwdxwB.y6cUMSNjXTe4sFqkhWqXZSQpsKs6Pz6BbXklMggEl6', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'susan', N'{bcrypt}$2a$10$12tNGY/2mOywEOYufGcLnuICjFl/Z3F/FWl4UAq2zcqUwZbFm/mdW', 1)
ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FK_authorities_users] FOREIGN KEY([username])
REFERENCES [dbo].[users] ([username])
GO
ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FK_authorities_users]
GO
USE [master]
GO
ALTER DATABASE [spring_security_demo_encrypted] SET  READ_WRITE 
GO
