USE [master]
GO
/****** Object:  Database [MyLibrary]    Script Date: 08/09/2017 11:33:06 ******/
CREATE DATABASE [MyLibrary]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MyLibrary', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MyLibrary.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MyLibrary_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MyLibrary_log.ldf' , SIZE = 1088KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
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
ALTER DATABASE [MyLibrary] SET AUTO_CLOSE OFF 
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
ALTER DATABASE [MyLibrary] SET  DISABLE_BROKER 
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
ALTER DATABASE [MyLibrary] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MyLibrary] SET  MULTI_USER 
GO
ALTER DATABASE [MyLibrary] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MyLibrary] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MyLibrary] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MyLibrary] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
USE [MyLibrary]
GO
/****** Object:  Table [dbo].[AccessProfile]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AccessProfile](
	[accProfilId] [bit] NULL,
	[accProfileName] [varchar](20) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Address]    Script Date: 08/09/2017 11:33:06 ******/
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
	[myLibraryId] [bigint] NOT NULL,
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
/****** Object:  Table [dbo].[Association]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Association](
	[booIsbn13] [varchar](13) NOT NULL,
	[subId] [numeric](18, 0) NOT NULL,
 CONSTRAINT [pkAssociationBookSubTheme] PRIMARY KEY CLUSTERED 
(
	[booIsbn13] ASC,
	[subId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Author]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Author](
	[autId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[autLastName] [varchar](50) NOT NULL,
	[autFirstName] [varchar](50) NULL,
	[autBiography] [varchar](255) NULL,
	[autStatusCode] [tinyint] NULL,
 CONSTRAINT [pkAuthor] PRIMARY KEY CLUSTERED 
(
	[autId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Book]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Book](
	[booIsbn13] [varchar](13) NOT NULL,
	[vatId] [numeric](18, 0) NULL,
	[revId] [numeric](18, 0) NULL,
	[ediName] [varchar](50) NULL,
	[booTitle] [varchar](50) NOT NULL,
	[booSubtitle] [varchar](50) NULL,
	[booPublishYear] [datetime] NOT NULL,
	[booPriceHT] [money] NOT NULL,
	[booResume] [varchar](255) NULL,
	[booQuantity] [int] NULL,
	[booStatus] [tinyint] NOT NULL,
	[booFrontCover] [varchar](255) NULL,
	[booPageNumber] [int] NULL,
 CONSTRAINT [pkBook] PRIMARY KEY CLUSTERED 
(
	[booIsbn13] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BookLanguage]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BookLanguage](
	[bookLangCode] [varchar](50) NOT NULL,
	[bookLangName] [varchar](50) NOT NULL,
 CONSTRAINT [pkBookLang] PRIMARY KEY CLUSTERED 
(
	[bookLangCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
	[cusComment] [varchar](255) NULL,
 CONSTRAINT [pkCustomer] PRIMARY KEY CLUSTERED 
(
	[cusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Definitions]    Script Date: 08/09/2017 11:33:06 ******/
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
/****** Object:  Table [dbo].[Determinate]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Determinate](
	[staId] [bit] NOT NULL,
	[purId] [bigint] IDENTITY(76527,1) NOT NULL,
	[detTime] [datetime] NOT NULL,
 CONSTRAINT [pkDeterminate] PRIMARY KEY CLUSTERED 
(
	[staId] ASC,
	[purId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Editor]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Editor](
	[ediName] [varchar](50) NOT NULL,
	[ediPresentation] [varchar](255) NULL,
	[ediStatusCode] [tinyint] NOT NULL,
 CONSTRAINT [pkEditor] PRIMARY KEY CLUSTERED 
(
	[ediName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[empId] [bigint] IDENTITY(1,1) NOT NULL,
	[empFirstName] [varchar](50) NOT NULL,
	[empLastName] [varchar](50) NOT NULL,
	[empLogin] [varchar](50) NOT NULL,
	[empPassword] [varchar](50) NOT NULL,
	[empDateStart] [date] NOT NULL,
	[empDateEnd] [date] NULL,
	[empStatus] [bit] NOT NULL,
 CONSTRAINT [pkEmployee] PRIMARY KEY CLUSTERED 
(
	[empId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Formats]    Script Date: 08/09/2017 11:33:06 ******/
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
/****** Object:  Table [dbo].[GettingAccess]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GettingAccess](
	[empId] [int] NOT NULL,
	[accProfilId] [bit] NOT NULL,
	[getStartDate] [datetime] NULL,
	[getEndDate] [datetime] NULL,
 CONSTRAINT [pkgetAccess] PRIMARY KEY CLUSTERED 
(
	[empId] ASC,
	[accProfilId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Have]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Have](
	[offId] [numeric](18, 0) NOT NULL,
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
/****** Object:  Table [dbo].[Keywords]    Script Date: 08/09/2017 11:33:06 ******/
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
/****** Object:  Table [dbo].[MyLibrary]    Script Date: 08/09/2017 11:33:06 ******/
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
 CONSTRAINT [pkMyLibId] PRIMARY KEY CLUSTERED 
(
	[myLibId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Offer]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Offer](
	[offId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[OrderLine]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderLine](
	[ordLineId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[purId] [numeric](18, 0) NULL,
	[booIsbn13] [varchar](13) NULL,
	[ordLineQuantity] [int] NOT NULL,
	[ordBookPriceHT] [money] NOT NULL,
	[ordBookVAT] [float] NOT NULL,
 CONSTRAINT [pkOrderLine] PRIMARY KEY CLUSTERED 
(
	[ordLineId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderStatus]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderStatus](
	[staId] [bit] NOT NULL,
	[staValidate] [bit] NULL,
 CONSTRAINT [pkStatId] PRIMARY KEY CLUSTERED 
(
	[staId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Payment]    Script Date: 08/09/2017 11:33:06 ******/
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
/****** Object:  Table [dbo].[Possession]    Script Date: 08/09/2017 11:33:06 ******/
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
/****** Object:  Table [dbo].[Purchase]    Script Date: 08/09/2017 11:33:06 ******/
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
/****** Object:  Table [dbo].[Review]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Review](
	[revId] [bigint] IDENTITY(1,1) NOT NULL,
	[cusId] [int] NOT NULL,
	[booIsbn13] [varchar](13) NOT NULL,
	[ordLineId] [int] NOT NULL,
	[revNote] [float] NULL,
	[revComment] [varchar](255) NULL,
	[revDate] [datetime] NULL,
	[revIP] [varchar](50) NULL,
 CONSTRAINT [pkreview] PRIMARY KEY CLUSTERED 
(
	[revId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Shipper]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Shipper](
	[ShipperId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[ShipperName] [varchar](50) NOT NULL,
 CONSTRAINT [pkShipper] PRIMARY KEY CLUSTERED 
(
	[ShipperId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ShippingCost]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ShippingCost](
	[shipId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[shipperId] [numeric](18, 0) NULL,
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
/****** Object:  Table [dbo].[StatusDisplay]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusDisplay](
	[staId] [bit] NOT NULL,
	[staValidate] [bit] NULL,
 CONSTRAINT [pkStaCode] PRIMARY KEY CLUSTERED 
(
	[staId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SubTheme]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SubTheme](
	[subId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[theId] [numeric](18, 0) NULL,
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
/****** Object:  Table [dbo].[Theme]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Theme](
	[theId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[Vat]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Vat](
	[vatId] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[vatRate] [float] NOT NULL,
	[vatName] [varchar](20) NOT NULL,
 CONSTRAINT [pkVat] PRIMARY KEY CLUSTERED 
(
	[vatId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Writing]    Script Date: 08/09/2017 11:33:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Writing](
	[booIsbn13] [varchar](13) NOT NULL,
	[autId] [numeric](18, 0) NOT NULL,
 CONSTRAINT [pkWriting] PRIMARY KEY CLUSTERED 
(
	[booIsbn13] ASC,
	[autId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [master]
GO
ALTER DATABASE [MyLibrary] SET  READ_WRITE 
GO
