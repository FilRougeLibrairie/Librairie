/*    ==Paramètres de script==

    Version du serveur source : SQL Server 2016 (13.0.4206)
    Édition du moteur de base de données source : Microsoft SQL Server Express Edition
    Type du moteur de base de données source : SQL Server autonome

    Version du serveur cible : SQL Server 2017
    Édition du moteur de base de données cible : Microsoft SQL Server Standard Edition
    Type du moteur de base de données cible : SQL Server autonome
*/
USE [master]
GO
/****** Object:  Database [myLibrary]    Script Date: 07/09/2017 19:54:50 ******/
CREATE DATABASE [myLibrary]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'myLibrary', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\myLibrary.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'myLibrary_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\myLibrary_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [myLibrary] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [myLibrary].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [myLibrary] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [myLibrary] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [myLibrary] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [myLibrary] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [myLibrary] SET ARITHABORT OFF 
GO
ALTER DATABASE [myLibrary] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [myLibrary] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [myLibrary] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [myLibrary] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [myLibrary] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [myLibrary] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [myLibrary] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [myLibrary] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [myLibrary] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [myLibrary] SET  DISABLE_BROKER 
GO
ALTER DATABASE [myLibrary] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [myLibrary] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [myLibrary] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [myLibrary] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [myLibrary] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [myLibrary] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [myLibrary] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [myLibrary] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [myLibrary] SET  MULTI_USER 
GO
ALTER DATABASE [myLibrary] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [myLibrary] SET DB_CHAINING OFF 
GO
ALTER DATABASE [myLibrary] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [myLibrary] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [myLibrary] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [myLibrary] SET QUERY_STORE = OFF
GO
USE [myLibrary]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [myLibrary]
GO
/****** Object:  Table [dbo].[AccessProfile]    Script Date: 07/09/2017 19:54:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccessProfile](
	[accProfilId] [bit] NULL,
	[accProfileName] [varchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 07/09/2017 19:54:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[cusID] [bigint] IDENTITY(1978,1) NOT NULL,
	[cusGender] [nchar](10) NULL,
	[cusFirstName] [varchar](50) NOT NULL,
	[cusLastName] [varchar](50) NOT NULL,
	[cusOrginastionName] [varchar](50) NULL,
	[cusEmail] [varchar](50) NOT NULL,
	[cusPhoneNumber] [varchar](50) NULL,
	[cusDateOfBirth] [date] NULL,
	[cusPassword] [varchar](50) NOT NULL,
	[cusIP] [varchar](50) NULL,
	[cusStatus] [bit] NOT NULL,
	[cusComment] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 07/09/2017 19:54:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[empId] [bigint] IDENTITY(1,1) NOT NULL,
	[empFirstName] [varchar](50) NOT NULL,
	[empLastName] [varchar](50) NOT NULL,
	[empLogin] [varchar](50) NOT NULL,
	[empPassword] [varchar](50) NOT NULL,
	[empDateStart] [date] NOT NULL,
	[empDateEnd] [date] NULL,
	[empStatus] [bit] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GettingAccess]    Script Date: 07/09/2017 19:54:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GettingAccess](
	[empId] [int] NOT NULL,
	[accProfileId] [bit] NOT NULL,
	[getStartDate] [datetime] NULL,
	[getEndDate] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Review]    Script Date: 07/09/2017 19:54:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[revId] [bigint] IDENTITY(1,1) NOT NULL,
	[cusId] [int] NOT NULL,
	[booIsbn13] [varchar] (13) NOT NULL,
	[ordLineId] [int] NOT NULL,
	[revNote] [float] NULL,
	[revComment] [varchar](255) NULL,
	[revDate] [datetime] NULL,
	[revIP] [varchar](50) NULL
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [myLibrary] SET  READ_WRITE 
GO
