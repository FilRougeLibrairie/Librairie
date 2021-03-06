USE [master]
GO
/****** Object:  Database [MyLibrary]    Script Date: 12/09/2017 11:43:47 ******/
CREATE DATABASE [MyLibrary]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MyLibrary', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MyLibrary.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MyLibrary_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MyLibrary_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MyLibrary] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MyLibrary].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MyLibrary] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MyLibrary] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MyLibrary] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MyLibrary] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MyLibrary] SET ARITHABORT OFF 
GO
ALTER DATABASE [MyLibrary] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [MyLibrary] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [MyLibrary] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MyLibrary] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MyLibrary] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MyLibrary] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MyLibrary] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MyLibrary] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MyLibrary] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MyLibrary] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MyLibrary] SET  ENABLE_BROKER 
GO
ALTER DATABASE [MyLibrary] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MyLibrary] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MyLibrary] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MyLibrary] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MyLibrary] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MyLibrary] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MyLibrary] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MyLibrary] SET RECOVERY FULL 
GO
ALTER DATABASE [MyLibrary] SET  MULTI_USER 
GO
ALTER DATABASE [MyLibrary] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MyLibrary] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MyLibrary] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MyLibrary] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [MyLibrary]
GO
/****** Object:  Table [dbo].[AccessProfile]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AccessProfile](
	[accProfileCode] [int] NOT NULL,
	[accProfileName] [varchar](20) NULL,
 CONSTRAINT [PK_AccessProfile] PRIMARY KEY CLUSTERED 
(
	[accProfileCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Address]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Address](
	[addId] [bigint] IDENTITY(1,1) NOT NULL,
	[cusResidId] [bigint] NOT NULL,
	[cusChargeId] [bigint] NOT NULL,
	[addLabel] [varchar](255) NULL,
	[addFirstName] [varchar](50) NULL,
	[addLastName] [varchar](50) NULL,
	[addCompany] [varchar](50) NULL,
	[addNumber] [varchar](10) NULL,
	[addStreetType] [varchar](15) NULL,
	[addStreetName] [varchar](50) NULL,
	[addComplement] [varchar](50) NULL,
	[addZipCode] [varchar](10) NULL,
	[addCity] [varchar](50) NULL,
	[addSecurityCode] [varchar](50) NULL,
	[addPhone] [varchar](50) NULL,
 CONSTRAINT [pkaddId] PRIMARY KEY CLUSTERED 
(
	[addId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Association]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Association](
	[booIsbn13] [varchar](13) NOT NULL,
	[subId] [bigint] NOT NULL,
 CONSTRAINT [pkAssociationBookSubTheme] PRIMARY KEY CLUSTERED 
(
	[booIsbn13] ASC,
	[subId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Author]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Author](
	[autId] [bigint] IDENTITY(1,1) NOT NULL,
	[autLastName] [varchar](50) NOT NULL,
	[autFirstName] [varchar](50) NULL,
	[autBiography] [varchar](255) NULL,
	[autStatusCode] [int] NULL,
 CONSTRAINT [pkAuthor] PRIMARY KEY CLUSTERED 
(
	[autId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Book]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Book](
	[booIsbn13] [varchar](13) NOT NULL,
	[vatCode] [int] NULL,
	[ediId] [int] NULL,
	[booTitle] [varchar](50) NOT NULL,
	[booSubtitle] [varchar](50) NULL,
	[booPublishYear] [date] NOT NULL,
	[booPriceHT] [float] NOT NULL,
	[booResume] [varchar](max) NULL,
	[booQuantity] [int] NULL,
	[booStatus] [int] NOT NULL,
	[booFrontCover] [varchar](255) NULL,
	[booPageNumber] [int] NULL,
	[bookLangCode] [int] NULL,
 CONSTRAINT [pkBook] PRIMARY KEY CLUSTERED 
(
	[booIsbn13] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BookLanguage]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BookLanguage](
	[bookLangCode] [int] NOT NULL,
	[bookLangName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_BookLanguage] PRIMARY KEY CLUSTERED 
(
	[bookLangCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customer](
	[cusId] [bigint] IDENTITY(1978,1) NOT NULL,
	[cusGender] [nchar](10) NULL,
	[cusLastName] [varchar](50) NOT NULL,
	[cusFirstName] [varchar](50) NOT NULL,
	[cusOrganisationName] [varchar](50) NULL,
	[cusEmail] [varchar](50) NOT NULL,
	[cusPhoneNumber] [varchar](50) NULL,
	[cusDateOfBirth] [date] NULL,
	[cusPassword] [varchar](255) NOT NULL,
	[cusSalt] [varchar](255) NOT NULL,
	[cusIP] [varchar](50) NULL,
	[cusStatus] [int] NOT NULL,
	[cusComment] [varchar](255) NULL,
 CONSTRAINT [pkCustomer] PRIMARY KEY CLUSTERED 
(
	[cusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Definitions]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Definitions](
	[keyName] [varchar](50) NOT NULL,
	[booIsbn13] [varchar](13) NOT NULL,
 CONSTRAINT [pkDefKeyNameBooIsbn13] PRIMARY KEY CLUSTERED 
(
	[keyName] ASC,
	[booIsbn13] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Determinate]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Determinate](
	[staCode] [int] NOT NULL,
	[purId] [bigint] NOT NULL,
	[detTime] [datetime] NOT NULL,
 CONSTRAINT [pkDeterminate] PRIMARY KEY CLUSTERED 
(
	[staCode] ASC,
	[purId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Editor]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Editor](
	[ediId] [int] IDENTITY(1,1) NOT NULL,
	[ediName] [varchar](50) NOT NULL,
	[ediPresentation] [varchar](255) NULL,
	[ediStatusCode] [int] NOT NULL,
 CONSTRAINT [PK_Editor] PRIMARY KEY CLUSTERED 
(
	[ediId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[empId] [bigint] IDENTITY(1,1) NOT NULL,
	[empLastName] [varchar](50) NOT NULL,
	[empFirstName] [varchar](50) NOT NULL,
	[empLogin] [varchar](50) NOT NULL,
	[empPassword] [varchar](255) NOT NULL,
	[empSalt] [varchar](255) NOT NULL,
	[empDateStart] [date] NOT NULL,
	[empDateEnd] [date] NULL,
	[empStatus] [int] NOT NULL,
	[empComment] [varchar](255) NULL,
 CONSTRAINT [pkEmployee] PRIMARY KEY CLUSTERED 
(
	[empId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Formats]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Formats](
	[forName] [varchar](50) NOT NULL,
 CONSTRAINT [pkFormats] PRIMARY KEY CLUSTERED 
(
	[forName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GettingAccess]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GettingAccess](
	[empId] [bigint] NOT NULL,
	[accProfileCode] [int] NOT NULL,
	[getStartDate] [datetime] NULL,
	[getEndDate] [datetime] NULL,
 CONSTRAINT [pkgetAccess] PRIMARY KEY CLUSTERED 
(
	[empId] ASC,
	[accProfileCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Have]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Have](
	[offId] [bigint] NOT NULL,
	[booIsbn13] [varchar](13) NOT NULL,
 CONSTRAINT [pkHave] PRIMARY KEY CLUSTERED 
(
	[offId] ASC,
	[booIsbn13] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Keywords]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Keywords](
	[keyName] [varchar](50) NOT NULL,
 CONSTRAINT [pkKeywords] PRIMARY KEY CLUSTERED 
(
	[keyName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MyLibrary]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MyLibrary](
	[myLibId] [bigint] IDENTITY(1,1) NOT NULL,
	[myLibName] [varchar](50) NOT NULL,
	[myLibLogo] [varchar](255) NULL,
	[myLibEmail] [varchar](50) NULL,
	[myLibPhone] [varchar](20) NULL,
	[myLibSiret] [varchar](14) NULL,
	[myLibCGU] [varchar](max) NULL,
	[myLibAddNumber] [varchar](3) NULL,
	[myLibAddStreetName] [varchar](50) NULL,
	[myLibAddComplement] [varchar](50) NULL,
	[myLibAddZipCode] [varchar](50) NULL,
	[myLibAddCity] [varchar](50) NULL,
 CONSTRAINT [pkMyLibId] PRIMARY KEY CLUSTERED 
(
	[myLibId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Offer]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Offer](
	[offId] [bigint] IDENTITY(1,1) NOT NULL,
	[offName] [varchar](50) NOT NULL,
	[offText] [varchar](255) NULL,
	[offDateStart] [datetime] NOT NULL,
	[offDateEnd] [datetime] NULL,
	[offDiscount] [float] NULL,
	[offPicture] [varchar](255) NULL,
 CONSTRAINT [pkOffer] PRIMARY KEY CLUSTERED 
(
	[offId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderLine]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderLine](
	[ordLineId] [int] IDENTITY(1,1) NOT NULL,
	[purId] [bigint] NULL,
	[booIsbn13] [varchar](13) NULL,
	[ordLineQuantity] [int] NOT NULL,
	[ordBookPriceHT] [float] NOT NULL,
	[ordBookVAT] [float] NOT NULL,
 CONSTRAINT [pkOrderLine] PRIMARY KEY CLUSTERED 
(
	[ordLineId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderStatus]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderStatus](
	[staCode] [int] NOT NULL,
	[staName] [varchar](50) NULL,
 CONSTRAINT [PK_OrderStatus] PRIMARY KEY CLUSTERED 
(
	[staCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Payment](
	[payId] [int] NOT NULL,
	[purId] [bigint] NOT NULL,
	[payValidate] [bit] NULL,
	[payChoice] [varchar](50) NULL,
	[payDate] [datetime] NULL,
 CONSTRAINT [pkpayId] PRIMARY KEY CLUSTERED 
(
	[payId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Possession]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Possession](
	[forName] [varchar](50) NOT NULL,
	[booIsbn13] [varchar](13) NOT NULL,
 CONSTRAINT [pkPossForNameBooIsbn13] PRIMARY KEY CLUSTERED 
(
	[forName] ASC,
	[booIsbn13] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Purchase]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Purchase](
	[purId] [bigint] IDENTITY(57231,1) NOT NULL,
	[cusId] [bigint] NOT NULL,
	[shippingCostId] [bigint] NOT NULL,
	[addDeliveryId] [bigint] NOT NULL,
	[addInvoiceId] [bigint] NOT NULL,
	[purIP] [varchar](50) NULL,
	[shippingDate] [datetime] NULL,
	[shippingNumber] [bigint] NULL,
 CONSTRAINT [pkpurId] PRIMARY KEY CLUSTERED 
(
	[purId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Review]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Review](
	[revId] [bigint] IDENTITY(1,1) NOT NULL,
	[cusId] [bigint] NOT NULL,
	[booIsbn13] [varchar](13) NOT NULL,
	[ordLineId] [int] NOT NULL,
	[revNote] [float] NULL,
	[revComment] [varchar](255) NULL,
	[revDate] [datetime] NULL,
	[revIP] [varchar](50) NULL,
	[revStatus] [int] NULL,
 CONSTRAINT [pkreview] PRIMARY KEY CLUSTERED 
(
	[revId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Shipper]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Shipper](
	[ShipperId] [bigint] IDENTITY(1,1) NOT NULL,
	[ShipperName] [varchar](50) NOT NULL,
 CONSTRAINT [pkShipper] PRIMARY KEY CLUSTERED 
(
	[ShipperId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ShippingCost]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ShippingCost](
	[shipId] [bigint] IDENTITY(1,1) NOT NULL,
	[shipperId] [bigint] NULL,
	[shipName] [varchar](50) NOT NULL,
	[shipCost] [float] NOT NULL,
 CONSTRAINT [pkShippingCost] PRIMARY KEY CLUSTERED 
(
	[shipId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[StatusDisplay]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[StatusDisplay](
	[staCode] [int] NOT NULL,
	[staName] [varchar](50) NULL,
 CONSTRAINT [PK_dbo.StatusDisplay] PRIMARY KEY CLUSTERED 
(
	[staCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SubTheme]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SubTheme](
	[subId] [bigint] IDENTITY(1,1) NOT NULL,
	[theId] [bigint] NULL,
	[subName] [varchar](50) NOT NULL,
	[subDescription] [varchar](255) NULL,
 CONSTRAINT [pkSubTheme] PRIMARY KEY CLUSTERED 
(
	[subId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Theme]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Theme](
	[theId] [bigint] IDENTITY(1,1) NOT NULL,
	[theName] [varchar](50) NOT NULL,
	[theDescription] [varchar](255) NULL,
 CONSTRAINT [pkTheme] PRIMARY KEY CLUSTERED 
(
	[theId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Vat]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Vat](
	[vatCode] [int] NOT NULL,
	[vatRate] [float] NOT NULL,
	[vatName] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Vat] PRIMARY KEY CLUSTERED 
(
	[vatCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Writing]    Script Date: 12/09/2017 11:43:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Writing](
	[booIsbn13] [varchar](13) NOT NULL,
	[autId] [bigint] NOT NULL,
 CONSTRAINT [pkWriting] PRIMARY KEY CLUSTERED 
(
	[booIsbn13] ASC,
	[autId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [fkCusChargeId] FOREIGN KEY([cusChargeId])
REFERENCES [dbo].[Customer] ([cusId])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [fkCusChargeId]
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [fkCusResidId] FOREIGN KEY([cusResidId])
REFERENCES [dbo].[Customer] ([cusId])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [fkCusResidId]
GO
ALTER TABLE [dbo].[Association]  WITH CHECK ADD  CONSTRAINT [fkBooAsso] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[Association] CHECK CONSTRAINT [fkBooAsso]
GO
ALTER TABLE [dbo].[Association]  WITH CHECK ADD  CONSTRAINT [fkBooSubT] FOREIGN KEY([subId])
REFERENCES [dbo].[SubTheme] ([subId])
GO
ALTER TABLE [dbo].[Association] CHECK CONSTRAINT [fkBooSubT]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [fkBooEdi] FOREIGN KEY([ediId])
REFERENCES [dbo].[Editor] ([ediId])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [fkBooEdi]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [fkBooLang] FOREIGN KEY([bookLangCode])
REFERENCES [dbo].[BookLanguage] ([bookLangCode])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [fkBooLang]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [fkBooVat] FOREIGN KEY([vatCode])
REFERENCES [dbo].[Vat] ([vatCode])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [fkBooVat]
GO
ALTER TABLE [dbo].[Definitions]  WITH CHECK ADD  CONSTRAINT [fkBooIsbn13] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[Definitions] CHECK CONSTRAINT [fkBooIsbn13]
GO
ALTER TABLE [dbo].[Definitions]  WITH CHECK ADD  CONSTRAINT [fkKeyName] FOREIGN KEY([keyName])
REFERENCES [dbo].[Keywords] ([keyName])
GO
ALTER TABLE [dbo].[Definitions] CHECK CONSTRAINT [fkKeyName]
GO
ALTER TABLE [dbo].[Determinate]  WITH CHECK ADD  CONSTRAINT [fkDeterminatePurId] FOREIGN KEY([purId])
REFERENCES [dbo].[Purchase] ([purId])
GO
ALTER TABLE [dbo].[Determinate] CHECK CONSTRAINT [fkDeterminatePurId]
GO
ALTER TABLE [dbo].[Determinate]  WITH CHECK ADD  CONSTRAINT [fkDeterminateStaId] FOREIGN KEY([staCode])
REFERENCES [dbo].[OrderStatus] ([staCode])
GO
ALTER TABLE [dbo].[Determinate] CHECK CONSTRAINT [fkDeterminateStaId]
GO
ALTER TABLE [dbo].[GettingAccess]  WITH CHECK ADD  CONSTRAINT [fkAccessProEmploye] FOREIGN KEY([empId])
REFERENCES [dbo].[Employee] ([empId])
GO
ALTER TABLE [dbo].[GettingAccess] CHECK CONSTRAINT [fkAccessProEmploye]
GO
ALTER TABLE [dbo].[GettingAccess]  WITH CHECK ADD  CONSTRAINT [fkAccessProfil] FOREIGN KEY([accProfileCode])
REFERENCES [dbo].[AccessProfile] ([accProfileCode])
GO
ALTER TABLE [dbo].[GettingAccess] CHECK CONSTRAINT [fkAccessProfil]
GO
ALTER TABLE [dbo].[Have]  WITH CHECK ADD  CONSTRAINT [fkBooHave] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[Have] CHECK CONSTRAINT [fkBooHave]
GO
ALTER TABLE [dbo].[OrderLine]  WITH CHECK ADD  CONSTRAINT [fkBookIsbn13] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[OrderLine] CHECK CONSTRAINT [fkBookIsbn13]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [fkPurId] FOREIGN KEY([purId])
REFERENCES [dbo].[Purchase] ([purId])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [fkPurId]
GO
ALTER TABLE [dbo].[Possession]  WITH CHECK ADD  CONSTRAINT [fkBookIsbn] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[Possession] CHECK CONSTRAINT [fkBookIsbn]
GO
ALTER TABLE [dbo].[Possession]  WITH CHECK ADD  CONSTRAINT [fkFormatName] FOREIGN KEY([forName])
REFERENCES [dbo].[Formats] ([forName])
GO
ALTER TABLE [dbo].[Possession] CHECK CONSTRAINT [fkFormatName]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [fkAddDeliveryId] FOREIGN KEY([addDeliveryId])
REFERENCES [dbo].[Address] ([addId])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [fkAddDeliveryId]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [fkAddInvoiceId] FOREIGN KEY([addInvoiceId])
REFERENCES [dbo].[Address] ([addId])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [fkAddInvoiceId]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [fkCusId] FOREIGN KEY([cusId])
REFERENCES [dbo].[Customer] ([cusId])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [fkCusId]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [fkShippingCostId] FOREIGN KEY([shippingCostId])
REFERENCES [dbo].[ShippingCost] ([shipId])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [fkShippingCostId]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [fkCusReview] FOREIGN KEY([cusId])
REFERENCES [dbo].[Customer] ([cusId])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [fkCusReview]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [fkOrdLinReview] FOREIGN KEY([ordLineId])
REFERENCES [dbo].[OrderLine] ([ordLineId])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [fkOrdLinReview]
GO
ALTER TABLE [dbo].[ShippingCost]  WITH CHECK ADD  CONSTRAINT [fkShipperId] FOREIGN KEY([shipperId])
REFERENCES [dbo].[Shipper] ([ShipperId])
GO
ALTER TABLE [dbo].[ShippingCost] CHECK CONSTRAINT [fkShipperId]
GO
ALTER TABLE [dbo].[SubTheme]  WITH CHECK ADD  CONSTRAINT [fkTheme] FOREIGN KEY([theId])
REFERENCES [dbo].[Theme] ([theId])
GO
ALTER TABLE [dbo].[SubTheme] CHECK CONSTRAINT [fkTheme]
GO
ALTER TABLE [dbo].[Writing]  WITH CHECK ADD  CONSTRAINT [fkAutWriting] FOREIGN KEY([autId])
REFERENCES [dbo].[Author] ([autId])
GO
ALTER TABLE [dbo].[Writing] CHECK CONSTRAINT [fkAutWriting]
GO
ALTER TABLE [dbo].[Writing]  WITH CHECK ADD  CONSTRAINT [fkBooWriting] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[Writing] CHECK CONSTRAINT [fkBooWriting]
GO
USE [master]
GO
ALTER DATABASE [MyLibrary] SET  READ_WRITE 
GO
