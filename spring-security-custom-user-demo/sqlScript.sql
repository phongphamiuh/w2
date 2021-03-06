USE [master]
GO
/****** Object:  Database [spring_security_custom_user_demo]    Script Date: 4/4/2021 2:24:18 PM ******/
CREATE DATABASE [spring_security_custom_user_demo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'spring_security_custom_user_demo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\spring_security_custom_user_demo.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'spring_security_custom_user_demo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\spring_security_custom_user_demo_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [spring_security_custom_user_demo] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [spring_security_custom_user_demo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [spring_security_custom_user_demo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET ARITHABORT OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET  DISABLE_BROKER 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET RECOVERY FULL 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET  MULTI_USER 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [spring_security_custom_user_demo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [spring_security_custom_user_demo] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'spring_security_custom_user_demo', N'ON'
GO
USE [spring_security_custom_user_demo]
GO
/****** Object:  Table [dbo].[role]    Script Date: 4/4/2021 2:24:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user]    Script Date: 4/4/2021 2:24:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[firstname] [varchar](50) NOT NULL,
	[lastname] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[password] [char](80) NOT NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users_roles]    Script Date: 4/4/2021 2:24:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users_roles](
	[user_id] [int] NOT NULL,
	[role_id] [int] NOT NULL
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [spring_security_custom_user_demo] SET  READ_WRITE 
GO
