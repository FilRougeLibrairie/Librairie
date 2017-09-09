/*    ==Paramètres de script==

    Version du serveur source : SQL Server 2016 (13.0.4206)
    Édition du moteur de base de données source : Microsoft SQL Server Enterprise Edition
    Type du moteur de base de données source : SQL Server autonome

    Version du serveur cible : SQL Server 2017
    Édition du moteur de base de données cible : Microsoft SQL Server Standard Edition
    Type du moteur de base de données cible : SQL Server autonome
*/
USE [MyLibrary]
GO
/****** Object:  Table [dbo].[AccessProfile]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccessProfile](
	[accProfilCode] [int] NOT NULL,
	[accProfileName] [varchar](20) NULL,
 CONSTRAINT [PK_AccessProfile] PRIMARY KEY CLUSTERED 
(
	[accProfilCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Address]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Address](
	[addId] [bigint] IDENTITY(1,1) NOT NULL,
	[cusResidId] [bigint] NOT NULL,
	[cusChargeId] [bigint] NOT NULL,
	[myLibraryId] [bigint] NULL,
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
/****** Object:  Table [dbo].[Association]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Author]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Author](
	[autId] [bigint] IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[Book]    Script Date: 09/09/2017 17:54:08 123 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[booIsbn13] [varchar](13) NOT NULL,
	[vatCode] [int] NULL,
	[ediId] [int] NULL,
	[booTitle] [varchar](50) NOT NULL,
	[booSubtitle] [varchar](50) NULL,
	[booPublishYear] [varchar](50) NOT NULL,
	[booPriceHT] [float] NOT NULL,
	[booResume] [varchar](max) NULL,
	[booQuantity] [int] NULL,
	[booStatus] [tinyint] NOT NULL,
	[booFrontCover] [varchar](255) NULL,
	[booPageNumber] [int] NULL,
	[bookLangCode] [int] NULL,
 CONSTRAINT [pkBook] PRIMARY KEY CLUSTERED 
(
	[booIsbn13] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BookLanguage]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Customer]    Script Date: 09/09/2017 17:54:08 ******/
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
	[cusComment] [varchar](255) NULL,
 CONSTRAINT [pkCustomer] PRIMARY KEY CLUSTERED 
(
	[cusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Definitions]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Determinate]    Script Date: 09/09/2017 17:54:08 ******/
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
/****** Object:  Table [dbo].[Editor]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Editor](
	[ediId] [int] IDENTITY(1,1) NOT NULL,
	[ediName] [varchar](50) NOT NULL,
	[ediPresentation] [varchar](255) NULL,
	[ediStatusCode] [tinyint] NOT NULL,
 CONSTRAINT [PK_Editor] PRIMARY KEY CLUSTERED 
(
	[ediId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 09/09/2017 17:54:08 ******/
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
	[empStatus] [bit] NOT NULL,
 CONSTRAINT [pkEmployee] PRIMARY KEY CLUSTERED 
(
	[empId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Formats]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Formats](
	[forName] [varchar](50) NOT NULL,
 CONSTRAINT [pkFormats] PRIMARY KEY CLUSTERED 
(
	[forName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GettingAccess]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GettingAccess](
	[empId] [bigint] NOT NULL,
	[accProfilCode] [int] NOT NULL,
	[getStartDate] [datetime] NULL,
	[getEndDate] [datetime] NULL,
 CONSTRAINT [pkgetAccess] PRIMARY KEY CLUSTERED 
(
	[empId] ASC,
	[accProfilCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Have]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Keywords]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Keywords](
	[keyName] [varchar](50) NOT NULL,
 CONSTRAINT [pkKeywords] PRIMARY KEY CLUSTERED 
(
	[keyName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MyLibrary]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Offer]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[OrderLine]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[OrderStatus]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Payment]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Possession]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Purchase]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Review]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
 CONSTRAINT [pkreview] PRIMARY KEY CLUSTERED 
(
	[revId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shipper]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[ShippingCost]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[StatusDisplay]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[SubTheme]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Theme]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Vat]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[Writing]    Script Date: 09/09/2017 17:54:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
INSERT [dbo].[AccessProfile] ([accProfilCode], [accProfileName]) VALUES (0, N'No Access')
INSERT [dbo].[AccessProfile] ([accProfilCode], [accProfileName]) VALUES (1, N'Administrateur
')
INSERT [dbo].[AccessProfile] ([accProfilCode], [accProfileName]) VALUES (2, N'Acces Editeur
')
INSERT [dbo].[AccessProfile] ([accProfilCode], [accProfileName]) VALUES (3, N'Acces Client')
INSERT [dbo].[AccessProfile] ([accProfilCode], [accProfileName]) VALUES (4, N'Acces Refusé
')
SET IDENTITY_INSERT [dbo].[Address] ON 

INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (0, 1978, 1978, 0, NULL, NULL, NULL, NULL, N'1', N'avenue', N'de Paris', NULL, N'75012', N'PARIS', NULL, N'08 15 45 64 76 
')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (1, 1981, 1981, 0, N'Adresse Maison
', N'Percy
', N'Lizotte
', NULL, N'1', N'avenue', N'de Marseille', NULL, N'75014', N'PARIS', NULL, N'06 15 78 45 65')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (2, 1981, 1981, 0, N'Adresse Travail
', N'Percy
', N'Lizotte
', N'Gallenkamp
', N'1
', N'avenue', N'de Lyon', NULL, N'75014', N'PARIS', NULL, N'06 46 48 45 46')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (3, 1982, 1982, 0, N'Adresse Maison', N'Brunelle
', N'Armand 
', NULL, N'10
', N'rue', N'de Lyon', N'app 104', N'41000', N'BLOIS', NULL, N'06 78 46 51 48')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (4, 1982, 1982, 0, N'Adresse Soeur', N'Brunelle', N'Brigitte', NULL, N'6', N'rue', N'du Chemin', NULL, N'41000', N'BLOIS', NULL, N'06 58 46 51 45')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (5, 1985, 1985, 0, N'Adresse Maison', N'Courtois', N'Geoffrey 
', NULL, N'25', N'rue', N'Albert Camis', NULL, N'29100', N'DOUARNENEZ', NULL, N'06 45 84 62 51')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (6, 1985, 1985, 0, N'Adresse autre', N'Courtois', N'Gilles', NULL, N'1', N'avenue', N'de Toulouse', NULL, N'16420', N'BRIGUEIL', N'051424V', N'06 78 41 15 49')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (7, 1985, 1985, 0, N'Adresse Travail', N'Courtois', N'Geoffrey', NULL, N'1', N'rue', N'du Puit', NULL, N'29100', N'DOUARNENEZ', NULL, N'09 75 45 65 42')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (8, 1986, 1986, 0, N'Adresse Principale', N'De Launay
', N'Diane', NULL, NULL, NULL, N'Le chemin', NULL, N'92130', N'ISSY LES MOULINEAUX', NULL, N'01 78 62 54 48')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (9, 1986, 1986, 0, N'Adresse Secondaire', N'De Launay', N'Diane', NULL, NULL, NULL, N'Lieu Perdu', NULL, N'91240', N'ST MICHEL SUR ORGE', NULL, N'01 65 48 54 65')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (10, 1987, 1987, 0, NULL, N'Parmentier
', N'Robinette 
', NULL, N'15', N'rue', N'du Retour', NULL, N'70100', N'ARC LES GRAY', NULL, N'06 45 48 45 65')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (11, 1987, 1987, 0, NULL, N'Parmentier
', N'Robinette', NULL, N'1', N'avenue', N'de Lyon', NULL, N'75014', N'PARIS', NULL, N'06 14 15 46 66')
INSERT [dbo].[Address] ([addId], [cusResidId], [cusChargeId], [myLibraryId], [addLabel], [addFirstName], [addLastName], [addCompany], [addNumber], [addStreetType], [addStreetName], [addComplement], [addZipCode], [addCity], [addSecurityCode], [addPhone]) VALUES (12, 1979, 1980, 0, NULL, N' Dubé
', N'Olympia 
', NULL, N'1', N'avenue', N'de Moscou', NULL, N'41000', N'BLOIS', NULL, N'04 15 14 65 25')
SET IDENTITY_INSERT [dbo].[Address] OFF
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782226328717', 8)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782226393197', 3)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782226393197', 4)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782226393197', 5)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782226399168', 1)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782226399168', 2)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782253083276', 8)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782253132943', 8)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782253132943', 9)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782253132943', 10)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782266130288', 6)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782266130288', 7)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782266276542', 11)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782266276542', 12)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782266276542', 14)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782290138922', 19)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782290138922', 22)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782747082600', 24)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782755614664', 6)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782755614664', 15)
INSERT [dbo].[Association] ([booIsbn13], [subId]) VALUES (N'9782755614664', 16)
SET IDENTITY_INSERT [dbo].[Author] ON 

INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (1, N'Nothomb
', N'Amélie
', N'Amélie Nothom, nom de plume de Fabienne Claire, baronne Nothomb, née le 9 juillet 1966 à Etterbeek, Bruxelles, est une romancière belge d''expression française.
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (2, N'Whitehead
', N'Colson', N'Colson Whitehead (son nom complet est Arch Colson Chipp Whitehead), né le 6 novembre 1969 à New York, est un romancier américain.
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (3, N'Horn
', N'Mike', N'Mike Horn (Michael Frédérick Horn), né le 16 juillet 1966 (51 ans) à Johannesbourg (Afrique du Sud), est un explorateur-aventurier de nationalité suisse et sud-africaine, de culture afrikaner, résidant en Suisse.
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (4, N'King
', N'Stephen
', N'Stephen King est un écrivain américain né le 21 septembre 1947 à Portland, dans le Maine (États-Unis).
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (5, N'Thilliez
', N'Franck', NULL, 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (6, N'Kinsella
', N'Sophie
', N'Sophie Kinsella, née le 12 décembre 1969 à Londres, est une femme de lettres britannique.
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (7, N'Burd
', N'Barry
', NULL, 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (8, N'Martin
', N'George R.R.', N'George R. R. Martin, né le 20 septembre 1948 à Bayonne (New Jersey)
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (9, N'Asset
', N'Bernard
', NULL, 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (10, N'Briand
', N'Arnaud
', NULL, 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (11, N'Delacroix
', N'Sibylle
', N'Sibylle Delacroix realise des illustrations pour la jeunesse (Hansel et Gretel, La Barbe Bleue, Pinocchio...) et pour la presse
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (12, N'Lambert
', N'Marc
', NULL, 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (13, N'Jeffries
', N'Sabrina
', NULL, 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (14, N'zep
', NULL, N'Zep, né Philippe Chappuis le 15 décembre 1967 à Onex, Genève, Suisse, est un auteur suisse de bandes dessinées dont la plus connue est Titeuf
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (15, N'Grisham
', N'John 
', N'John Grisham, né le 8 février 1955 à Jonesboro, dans l''Arkansas, est un écrivain américain, auteur de plusieurs romans policiers 
', 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (16, N'Himekawa 
', N'Akira
', NULL, 1)
INSERT [dbo].[Author] ([autId], [autLastName], [autFirstName], [autBiography], [autStatusCode]) VALUES (17, N'Hugo
', N'Victor
', NULL, 2)
SET IDENTITY_INSERT [dbo].[Author] OFF
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9781444799132', 0, 5, N'The whistler', NULL, N'2014', 7.55, NULL, 26, 0, N'images\cover\17.png', 384, 1)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782226328717', 0, 1, N'Fin de ronde', NULL, N'2015', 22.5, N'Dans la chambre 217 de l''hôpital Kiner Memorial, Brady Hartsfield, alias Mr Mercedes, gît dans un état végétatif depuis sept ans, soumis aux expérimentations du docteur Babineau. Mais derrière son rictus douloureux et son regard fixe, Brady est bien vivant. Et capable de commettre un nouveau carnage sans même quitter son lit. Sa première pensée est pour Bill Hodges, son plus vieil ennemi. « Après Mr Mercedes et Carnets noirs, les fans de Stephen King trouveront dans ce mélange de suspense et d''horreur la conclusion parfaite à la trilogie de l''inspecteur Hodges. » Publishers Weekly Stephen King a écrit plus de 50 romans, autant de best-sellers, et plus de 200 nouvelles. Couronné par de nombreux prix littéraires, il est devenu un mythe vivant de la littérature américaine (médaille de la National Book Foundation en 2003 pour sa contribution aux lettres américaines, Grand Master Award en 2007 pour l''ensemble de son ouvre). Fin de partie est le troisième volet de la trilogie mettant en scène Bill Hodges, après Carnets noirs (2016) et Mr Mercedes (2015), récompensé par le prix Edgar-Allan Poe 2015 du meilleur roman', 4, 0, N'images\cover\7.png', 430, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782226393197', 0, 1, N'Underground railroad ', NULL, N'2017', 21.64, N'Cora, seize ans, est esclave sur une plantation de coton dans la Géorgie d’avant la guerre de Sécession. Abandonnée par sa mère lorsqu’elle était enfant, elle survit tant bien que mal à la violence de sa condition. Lorsque Caesar, un esclave récemment arrivé de Virginie, lui propose de s’enfuir, elle accepte et tente, au péril de sa vie,  de gagner avec lui les États libres du Nord. De la Caroline du Sud à l’Indiana en passant par le Tennessee, Cora va vivre une incroyable odyssée. Traquée comme une bête par un impitoyable chasseur d’esclaves qui l’oblige à fuir, sans cesse, le « misérable cœur palpitant » des villes, elle fera tout pour conquérir sa liberté. L’une des prouesses de Colson Whitehead est de matérialiser l’« Underground Railroad », le célèbre réseau clandestin d’aide aux esclaves en fuite qui devient ici une véritable voie ferrée souterraine, pour explorer, avec une originalité et une maîtrise époustouflantes, les fondements et la mécanique du racisme. À la fois récit d’un combat poignant et réflexion saisissante sur la lecture de l’Histoire, ce roman, couronné par le prix Pulitzer, est une œuvre politique aujourd’hui plus que jamais nécessaire. « Un roman puissant et presque hallucinatoire. Une histoire essentielle pour comprendre les Américains d’hier et d’aujourd’hui. » The New York Times Né à New York en 1969, Colson Whitehead a été découvert en France avec la traduction de son premier roman, L’Intuitionniste. Ont suivi notamment Ballades pour John Henry, Le Colosse de New York ou encore Apex ou le cache-blessure (publiés aux Éditions Gallimard), qui tous ont confirmé l’exceptionnel talent de Colson Whitehead à inventer de véritables machines romanesques, irriguées par une méditation sur les mythologies américaines, ainsi que par une réflexion très politique sur la question raciale.', 100, 0, N'images\cover\1.png', 243, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782226399168', 0, 1, N'Frappe-toi le cœur ', NULL, N'2006', 15.97, N'« Frappe-toi le cœur, c’est là qu’est le génie. » Alfred de Musset Amélie Nothomb est née à Kobé en 1967. Dès son premier roman Hygiène de l’assassin paru en 1992, elle s’est imposée comme un écrivain singulier. En 1999, elle obtient avec Stupeur et tremblements le Grand Prix de l’Académie française. Frappe-toi le cœur  est son 26ème roman.', 300, 0, N'images\cover\0.png', 180, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782253014997', 0, 7, N'Les Contemplations', NULL, N'2015', 3.5, NULL, 50, 0, N'images\cover\19.png', 253, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782253083276', 0, 8, N'Carnets noirs', NULL, N'2016', 8.9, N'En prenant sa retraite, John Rothstein a plongé dans le désespoir les millions de lecteurs des aventures de Jimmy Gold. Devenu fou de rage depuis la disparition de son héros favori, Morris Bellamy assassine le vieil écrivain pour s''emparer de sa fortune et, surtout, de ses précieux carnets de notes. Le bonheur dans le crime ? C''était compter sans les mauvais tours du destin... et la perspicacité du détective Bill Hodges. Trente ans après Misery, Stephen King renoue avec l''un de ses thèmes de prédilection : l''obsession d''un fan. Dans ce formidable roman noir, où l''on retrouve les protagonistes de Mr Mercedes (prix Edgar 2015), il rend un superbe hommage au pouvoir de la fiction, capable de susciter chez le lecteur le meilleur... comme le pire. Un suspense de très haut niveau et une intrigue au déroulé parfait qui vont faire passer au lecteur de belles nuits blanches. Renaud Baronian, Le Parisien. Né en 1947 à Portland (Maine), Stephen King a connu son premier succès en 1974 avec Carrie. En une trentaine d''années, il a publié plus de cinquante romans et autant de nouvelles, certains sous le pseudonyme de Richard Bachman. Il a reçu de nombreuses distinctions littéraires, dont le prestigieux Grand Master Award des Mystery Writers of America pour l''ensemble de sa carrière en 2007. Son oeuvre a été largement adaptée au cinéma', 0, 0, N'images\cover\6.png', NULL, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782253132943', 0, 8, N'Mr Mercedes', NULL, N'2015', 22.19, N'Une fois n''est pas coutume, Stephen King délaisse le fantastique pour nous proposer un vrai roman noir. Mr Mercedes est un thriller pur jus où il sonde le cerveau malade d''un terrible chauffard psychopathe au goût prononcé pour les tueries de masse. Un roman poisseux et inconfortable, qui nous trouble par sa virtuosité narrative et l''épaisseur de ses personnages. Au fil d''une chasse à l''homme époustouflante, on se dit que, même hors de son terrain de jeu favori, le King reste le meilleur d''entre tous pour nous faire voyager dans les ténèbres. ', 105, 0, N'images\cover\4.png', 320, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782266130288', 0, 10, N'Latitude zéro ', N'40000 KM pour partir à la rencontre du monde', N'2014', 6.99, N'Le temps s''est ramassé sur lui-même. Il est devenu compact. Les dix-sept mois de Latitude 0 se sont peu à peu transformés, dans ma mémoire, en une sorte d''instant unique, d''une intensité époustouflante, pendant lequel j''ai vécu presque simultanément tout ce qu''il est possible de vivre. J''ai vu des enfants naître et des hommes mourir. J''ai longé des fleuves et escaladé des montagnes. J''ai connu la paix et j''ai vécu la guerre. J''ai éclaté de rire et j''ai pleuré toutes les larmes de mon corps. J''ai éprouvé la joie, la déception, la tristesse, la peur de mourir, l''euphorie et le désespoir. "   Mike Horn ne vit que pour réaliser ses rêves. Alors un jour de printemps, il a laissé sur un rivage sa femme et ses deux filles qu''il adore, pour faire le tour de la planète, seul, en suivant la ligne de l''équateur. À pied, en pirogue, à la voile ou à vélo, à travers trois océans et deux continents, Mike Horn a cheminé sur ce fil invisible. Sans jamais s''en écarter de plus de quarante kilomètres. Il raconte ici comment un homme seul parvient à se fondre dans la nature pour qu''elle le laisse passer - et parfois il n''y arrive pas. Dans la forêt vierge du Brésil, mordu par un serpent, il est resté quatre jours aveugle, à demi conscient, sans savoir si le venin était ou non mortel. Mais le plus grand danger, c''est l''homme et ses guerres. En Afrique, des rebelles ont arrêté Mike Horn et l''ont condamné à mort. Il ne s''en est tiré que de justesse. Pourquoi tout ça ? Parce qu''il voulait aller au bout de son rêve, plus loin dans la rencontre de la nature et des hommes.   On découvre dans ce récit hors du commun un homme qui a peur, qui s''émerveille, qui a mal, mais qui avance, toujours.', 0, 1, N'images\cover\3.png', 175, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782266272575', 0, 10, N'L''accro du shopping à la rescousse     ', NULL, N'2016', 6.99, N'Après avoir perdu la tête à Hollywood, entraînée par une célébrité aussi soudaine qu''éphémère, Becky redescend brutalement sur terre. Sans prévenir personne, son père est parti à la recherche d''un vieil ami, semble-t-il détenteur d''un lourd secret. Et Tarkie, le mari de sa meilleure amie, a disparu, comme hypnotisé par un gourou new age aux intentions troubles… Il n''en faudra pas plus à Becky pour entasser mari, amie et enfants dans un camping-car et partir à leur poursuite, dans un voyage s''annonçant haut en couleur', 250, 0, N'images\cover\9.png', 384, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782266276542', 0, 10, N'Rêver ', NULL, N'2017', 8.03, N'Psychologue réputée pour son expertise dans les affaires criminelles, Abigaël souffre d''une narcolepsie sévère qui lui fait confondre le rêve avec la réalité. De nombreux mystères planent autour de la jeune femme, notamment concernant l''accident qui a coûté la vie à son père et à sa fille, et dont elle est miraculeusement sortie indemne. L’affaire de disparition d’enfants sur laquelle elle travaille brouille ses derniers repères et fait bientôt basculer sa vie dans un cauchemar éveillé… Dans cette enquête, il y a une proie et un prédateur :...', 6, 0, N'images\cover\8.png', 656, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782290138922', 0, 7, N'La tour sombre', N'Nouvelle Edition augmentée Tome 1', N'2015', 7.8, N'Roland le Pistolero est le dernier justicier et aventurier d''un monde dont il cherche à inverser la destruction programmée. Pour cela, il doit arracher au sorcier vêtu de noir les secrets qui le mèneront vers la Tour sombre. Premier tome de la série, suivi d''un court roman.', 200, 0, N'images\cover\5.png', NULL, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782290145548', 0, 7, N'Quand la passion l''emporte', N'Les hommes du Duc Tome 2', N'2014', 6.99, N'Isabelle, la femme de Victor Cale, disparaît après leur mariage. Il la cherche et découvre qu''elle est impliquée dans un crime. Dix ans plus tard, il la croise par hasard. Isabella a beaucoup changé. La passion ressurgit entre eux deux, plus forte qu''avant', 150, 0, N'images\cover\15,png', NULL, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782290152331', 0, 7, N'Chroniques du chevalier errant     ', NULL, N'2015', 7.56, N'Qu''il joute ou qu''il guerroie, le chevalier errant n''a d''autre code que celui de l''honneur. Il met son talent au service des causes les plus nobles et prend la défense des opprimés. Ser Arlan suit cette ligne de conduite et l''inculque à son écuyer Dunk. La rencontre de ce dernier avec un étrange garçon qui se fait appeler Oeuf va changer à jamais son destin', 0, 0, N'images\cover\11.png', NULL, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782302064263', 1, 11, N'The Legend Of Zelda', N'Art and artifacts', N'2014', 31.98, N'Depuis une trentaine d’année, Nintendo a su faire vivre de grandes aventures épiques à son jeune héros Link dans sa quête permanente pour protéger le monde d’Hyrule et la princesse Zelda. Que ce soit les premiers dessins, les premiers sprites des jeux sorties sur Nintendo NES ou les grandes illustrations du dernier jeu sorti sur Switch, tous sont réunis dans plus de 400 pages d’illustrations agrémentés de commentaires et interview.', 50, 0, N'images\cover\18.png', 416, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782312015774', 0, 9, N'Souriez !', NULL, N'2015', 11.34, N'"Recette du mariage explosif"- Mélangez deux anciens amants accompagnés par leur compagnon respectif.- Jetez de l''huile sur le feu.- Retirez l''alliance et mettez-la au frais.- Montez les mariés en neige.- Epluchez les sentiments jusqu''à la dernière couche (attention, ça pique les yeux!)- Délayez avec beaucoup d''alcool.- Dans une sauteuse, versez un quiproquo et beaucoup d''égo.- Faites flamber le tout. Pimenter avec de l''ironie.Servez chaud.', 20, 0, N'images\cover\14.png', 148, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782344020937', 0, 4, N'Titeuf', N'tome 15 – A fond le slip', N'2013', 9.92, N'L''album qui va faire craquer toute la famille ! Que ce soit en classe, dans la cour de récré, à la maison ou dans la rue, Titeuf est très attentif au monde qui l’entoure. Mais en ce moment il est carrément perdu ! Entre les manifs contre les déchets nucléaires qui puent du slip comme les couches de Zizie et les gens qui descendent dans la rue contre les IVGétariens, il a l’impression qu’aujourd’hui il faut avoir un avis sur tout. Mais pô facile de faire le bon choix dans un monde qui devient de plus en plus compliqué ! Heureusement qu’il reste les copains et les vidéos sur internet pour tout nous expliquer. La mèche la plus célèbre de la BD est de retour ! Après un album remarqué imaginant son passage à l’adolescence, Titeuf revient pour un album de gags à la fois drôles, tendres et totalement connectés à notre époque. Des grands phénomènes de notre société moderne aux petites gamelles de la cour de récré, Zep utilise avec une virtuosité rare l’humour du quotidien pour scruter le monde à travers le regard de l’enfance – parfois insolent, toujours juste.', 15, 0, N'images\cover\16.png', 48, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782412020869', 0, 3, N'JAVA pour les nuls', NULL, N'2018', 23.57, N'Grâce à ce livre, vous allez rapidement écrire rapidement vos premières applets Java, sans pour autant devenir un gourou de la programmation objet', 150, 0, N'images\cover\10.png', 480, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782747082600', 0, 2, N'Graines de sable', NULL, N'2016', 11.24, N'Graines de sable évoque avec sensibilité le bonheur et la nostalgie des vacances.', 5, 0, N'images\cover\13.png', NULL, 9)
INSERT [dbo].[Book] ([booIsbn13], [vatCode], [ediId], [booTitle], [booSubtitle], [booPublishYear], [booPriceHT], [booResume], [booQuantity], [booStatus], [booFrontCover], [booPageNumber], [bookLangCode]) VALUES (N'9782755614664', 0, 6, N'Ayrton Senna', N'la victoire à tout prix     ', N'2015', 33.07, N'Evoquer la mémoire d''Ayrton Senna, évoquer sa personnalité, ses capacités ou sa popularité, c''est susciter la nostalgie d''un pilote légendaire. Comme le résuma un jour Gérard Ducarouge, le directeur technique de l''équipe Lotus aux côtés duquel il passa trois années et eu tout le temps de l''apprécier, Ayrton Senna était « un être d''exception, un perpétuel étonnement qui était doué pour tout. »C''est parce qu''il était bien plus qu''un sportif d''exception que Senna est, encore aujourd''hui, vingt ans après sa disparition, aussi vivant dans nos esprits. Personne n''a oublié sa détermination, son abnégation et son agressivité, sa façon de décrocher la pôle position en allant toujours plus vite et plus loin, et parfois au-delà de lui-même. Personne n''a oublié non plus son duel homérique avec Alain Prost, ses accrochages et son sens de la vindicte et de la justice. Personne n''a oublié ce visage déterminé, ce regard mélancolique et cette foi inébranlable en lui, qui lui ont valu de réaliser des prouesses et de nous gratifier sans cesse d''exploits.Adulé par certains, décrié par d''autres, Senna a eu le mérite de faire l''unanimité, même auprès de ses pairs, sur sa valeur et sa performance. Pour lui, la victoire n''avait pas de prix. Elle passait avant tout. Pour lui, il ne fallait jamais transiger avec le travail et toujours chercher à se surpasser, quitte même à aller parfois au-delà de ses limites. Prince de la pole position, roi des courses dantesques, il était la référence en matière de bravoure, de courage et de talent.Il n''a cessé durant toute sa carrière de nous gratifier de prouesses passées à jamais à la postérité. Des prouesses que le photographe Bernard Asset a immortalisées et que nous vous proposons de découvrir dans cet ouvrage richement illustré pour vivre le parcours de cette divinité qui, comme Achille, a payé de sa vie le prix de l''immortalité.', 15, 0, N'images\cover\12.png', NULL, 9)
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (0, N'Allemand
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (1, N'Anglais
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (2, N'Arabe
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (3, N'Chinois
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (4, N'Coréen
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (5, N'Croate
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (6, N'Danois
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (7, N'Espagnol
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (8, N'Finnois
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (9, N'Français
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (10, N'Grec
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (11, N'Hongrois
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (12, N'Italien
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (13, N'Néerlandais
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (14, N'Portugais
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (15, N'Roumain
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (16, N'Russe
')
INSERT [dbo].[BookLanguage] ([bookLangCode], [bookLangName]) VALUES (17, N'Turc
')
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1978, NULL, N'Caroline Librairie', N'Caroline Librairie', NULL, N'caroline@serviceClientCaroline.com
', NULL, NULL, N'caroline
', NULL, 0, N'caroline librairie')
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1979, N'F
        ', N'Sauvé
', N'Clarimunda
', N'Solid Future
', N'ClarimundaSauve@armyspy.com
', N'01 46 00 29 13
', CAST(N'1963-09-16' AS Date), N'"iNaNosh5h
"
', N'"117.153.221.193
"
', 0, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1980, N'F
        ', N'Olympia 
', N' Dubé
', N'Coon Chicken Inn
', N'OlympiaDube@armyspy.com
', N'05 64 60 12 28
', CAST(N'1982-05-19' AS Date), N'Gemee9evah
', N'159.157.196.44
', 1, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1981, N'H
        ', N'Percy
', N'Lizotte
', NULL, N'PercyLizotte@teleworm.us
', N'05 12 69 04 35
', CAST(N'1968-11-29' AS Date), N'meele9Ree8of
', N'207.105.185.229
', 1, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1982, N'H
        ', N'Brunelle
', N'Armand 
', N'Avant Garde Interior Designs
', N'ArmandBrunelle@teleworm.us
', N'03 11 70 05 09
', CAST(N'2010-05-01' AS Date), N'wo0Eizohmah
', N'80.29.91.9
', 1, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1983, N'H
        ', N'Quincy 
', N'Givry
', N'Lee Wards
', N'QuincyGivry@armyspy.com
', N'04 31 81 40 56
', CAST(N'1965-09-01' AS Date), N'Conage
', N'123.7.193.126
', 0, N'client fictif')
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1984, N'F
        ', N'Piedalue
', N'Morgana 
', N'The Warner Brothers Store
', N'MorganaPiedalue@teleworm.us
', N'05 55 84 25 13
', CAST(N'1985-02-01' AS Date), N'Eise8eix8
', N'74.93.9.192
', 0, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1985, N'F         ', N'Courtois
', N'Geoffrey 
', N'Gallenkamp
', N'GeoffreyCourtois@teleworm.us
', N'03 73 17 30 09
', CAST(N'1968-12-03' AS Date), N'IZaecoozu3
', N'59.37.245.21
', 1, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1986, N'F         ', N'De Launay
', N'Diane', NULL, N'DianedeLaunay@rhyta.com
', N'01 22 46 41 40
', CAST(N'1964-05-01' AS Date), N'oCh4die1goh
', N'55.166.3.118
', 1, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1987, N'F         ', N'Parmentier
', N'Robinette 
', NULL, N'RobinetteParmentier@jourrapide.com
', N'04 90 27 39 84
', CAST(N'1968-08-01' AS Date), N'ae0Ewowa
', N'8.47.40.245
', 1, NULL)
INSERT [dbo].[Customer] ([cusID], [cusGender], [cusFirstName], [cusLastName], [cusOrginastionName], [cusEmail], [cusPhoneNumber], [cusDateOfBirth], [cusPassword], [cusIP], [cusStatus], [cusComment]) VALUES (1988, N'H         ', N'Meunier
', N'Arthur', NULL, N'ArthurMeunier@rhyta.com
', N'01 06 35 79 24
', CAST(N'1986-06-02' AS Date), N'cooShai2
', N'56.62.27.186
', 0, NULL)
SET IDENTITY_INSERT [dbo].[Customer] OFF
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'accident
', N'9782266276542')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'bonheur
', N'9782747082600')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'Brésil
', N'9782266130288')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'Brésil
', N'9782755614664')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'cœur
', N'9782226399168')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'esclavage
', N'9782226393197')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'fantastique
', N'9782290138922')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'formule1
', N'9782755614664')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'guerre
', N'9782226393197')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'inspecteur
', N'9782253132943')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'légende
', N'9782755614664')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'mystère
', N'9782266276542')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'nature
', N'9782266130288')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'nostalgie
', N'9782747082600')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'odyssée
', N'9782226393197')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'psychologue
', N'9782266276542')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'psychopathe
', N'9782253132943')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'science fiction
', N'9782290138922')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'sensibilité
', N'9782747082600')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'thriller
', N'9782226328717')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'thriller
', N'9782253083276')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'thriller
', N'9782253132943')
INSERT [dbo].[Definitions] ([keyName], [booIsbn13]) VALUES (N'violence
', N'9782226399168')
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (1, 57232, CAST(N'2017-08-16T01:00:00.000' AS DateTime))
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (1, 57233, CAST(N'2017-08-17T02:00:00.000' AS DateTime))
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (1, 57234, CAST(N'2017-08-18T15:00:00.000' AS DateTime))
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (1, 57235, CAST(N'2017-08-19T13:00:00.000' AS DateTime))
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (1, 57236, CAST(N'2017-08-20T14:00:00.000' AS DateTime))
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (2, 57232, CAST(N'2017-08-24T15:30:00.000' AS DateTime))
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (2, 57235, CAST(N'2017-08-22T15:00:00.000' AS DateTime))
INSERT [dbo].[Determinate] ([staCode], [purId], [detTime]) VALUES (3, 57235, CAST(N'2017-08-24T21:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Editor] ON 

INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (1, N'Albin Michel', N'Depuis 1992, Albin Michel publie environ 450 nouveautés par an (pour 100 en 1967). Quatrième groupe d''édition français, ses auteurs se classent régulièrement parmi les meilleures ventes', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (2, N'Bayard Jeunesse
', N'Bayard est un groupe de presse français créé en 1873, juste après la guerre franco-prussienne de 1870, par le père Emmanuel d''Alzon (1810/1880).', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (3, N'First Interactive 
', N'Editis est un groupe d''édition français constitué en janvier 2004 et appartenant à Grupo Planeta (Espagne).', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (4, N'Glenat
', NULL, 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (5, N'Hodder & Stoughton Libri
', NULL, 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (6, N'Hugo Sport
', N'Hugo, une maison d’éditeurs ! Maison d’éditeurs avec un S…', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (7, N'J''ai Lu
', N'J''ai lu est une maison d''édition française à Paris créée en 1958 par Frédéric Ditis à la demande d''Henri Flammarion1. Sa ligne éditoriale est très variée', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (8, N'Le livre de poche
', N'Le Livre de poche (parfois abrégé LDP) est, à l''origine, le nom d''une collection littéraire apparue le 9 février 1953 sous l''impulsion d''Henri Filipacchi et éditée par la Librairie générale française, filiale d''Hachette depuis 1954.
', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (9, N'Les editions du net
', N'Nombreux sont les auteurs qui ont choisi de faire confiance aux Editions du Net pour la publication de leur ouvrage. En résulte un catalogue très fourni où les nouveautés littéraires en tous genres se côtoient.', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (10, N'Pocket
', N'Créé à l''origine par les Presses de la Cité en 1962 sous le nom de Presses Pocket, Pocket est un éditeur généraliste de littérature au format poche dont les collections couvrent tous les genres de la fiction et de la non-fiction.', 1)
INSERT [dbo].[Editor] ([ediId], [ediName], [ediPresentation], [ediStatusCode]) VALUES (11, N'Soleil
', N'Soleil Productions est un éditeur français de bande dessinée localisé à Toulon. Cette maison d''édition a vu le jour en 1989 après l''ouverture par Mourad Boudjellal, de la librairie Bédulle en 1982.', 1)
SET IDENTITY_INSERT [dbo].[Editor] OFF
SET IDENTITY_INSERT [dbo].[Employee] ON 

INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (1, N'Grenier
', N'Julie', N'Beas1995
', N'peP6oon0aith
', CAST(N'1995-06-30' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (2, N'Cantin', N'Anne', N'Waintassitan
', N'ahloZ7eew1ie
', CAST(N'1999-05-02' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (3, N'Goudreau
', N'Brice', N'Forcive
', N'aicaG4ree5
', CAST(N'1997-12-05' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (4, N'Artois', N'Merle', N'Shoseathe1983
', N'ahP2aoch
', CAST(N'2015-06-15' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (5, N'Poirier', N'Amélie', N'Eveyear
', N'baiHeiwie0
', CAST(N'2015-12-06' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (6, N'Bureau
', N'Valliant', N'Whowerromed
', N'koong5AiCh3
', CAST(N'2001-05-02' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (7, N'Guernon
', N'Alaine', N'Lactly
', N'AiK1MiGh2
', CAST(N'2014-12-09' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (8, N'Babin
', N'Tempeste', N'Hishad
', N'aob2Shex
', CAST(N'2006-02-11' AS Date), CAST(N'2015-07-08' AS Date), 0)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (9, N'Pitre
', N'Véronique', N'Abousid
', N'ood0oCeumi
', CAST(N'2000-09-23' AS Date), NULL, 1)
INSERT [dbo].[Employee] ([empId], [empFirstName], [empLastName], [empLogin], [empPassword], [empDateStart], [empDateEnd], [empStatus]) VALUES (10, N'Moquin
', N'Garland', N'Fultal
', N'Ohm1zaishee
', CAST(N'2015-09-23' AS Date), NULL, 1)
SET IDENTITY_INSERT [dbo].[Employee] OFF
INSERT [dbo].[Formats] ([forName]) VALUES (N'Grand Carré 30x30cm
')
INSERT [dbo].[Formats] ([forName]) VALUES (N'Grand Poche 13x20cm
')
INSERT [dbo].[Formats] ([forName]) VALUES (N'Grand Poche 15x23cm
')
INSERT [dbo].[Formats] ([forName]) VALUES (N'Grand Poche 21x26cm
')
INSERT [dbo].[Formats] ([forName]) VALUES (N'Magasine 22x28cm
')
INSERT [dbo].[Formats] ([forName]) VALUES (N'Paysage Grand Format 33x28cm
')
INSERT [dbo].[Formats] ([forName]) VALUES (N'Petit Carré 18x18cm
')
INSERT [dbo].[Formats] ([forName]) VALUES (N'Portrait Standard 20x25cm
')
INSERT [dbo].[Have] ([offId], [booIsbn13]) VALUES (2, N'9782226328717')
INSERT [dbo].[Have] ([offId], [booIsbn13]) VALUES (2, N'9782253083276')
INSERT [dbo].[Have] ([offId], [booIsbn13]) VALUES (2, N'9782290138922')
INSERT [dbo].[Have] ([offId], [booIsbn13]) VALUES (3, N'9782226393197')
INSERT [dbo].[Have] ([offId], [booIsbn13]) VALUES (3, N'9782226399168')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'accident
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'amour
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'bonheur
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'Brésil
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'cœur
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'esclavage
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'fantastique
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'formule1
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'guerre
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'inspecteur
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'légende
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'mystère
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'nature
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'nostalgie
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'odyssée
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'psychologue
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'psychopathe
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'science fiction
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'sensibilité
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'thriller
')
INSERT [dbo].[Keywords] ([keyName]) VALUES (N'violence
')
SET IDENTITY_INSERT [dbo].[MyLibrary] ON 

INSERT [dbo].[MyLibrary] ([myLibId], [myLibName], [myLibLogo], [myLibEmail], [myLibPhone], [myLibSiret], [myLibCGU]) VALUES (0, N'Caroline
', N'images\logo\logo.png
', N'caroline@serviceClientCaroline.com
', N'08 15 45 64 76', N'37900632300016', N'docs\cgu.txt
')
SET IDENTITY_INSERT [dbo].[MyLibrary] OFF
SET IDENTITY_INSERT [dbo].[Offer] ON 

INSERT [dbo].[Offer] ([offId], [offName], [offText], [offDateStart], [offDateEnd], [offDiscount], [offPicture]) VALUES (1, N'Rentree scolaire 2017
', N'Les essentiels de la rentrée scolaire 2017
', CAST(N'2017-08-28T00:00:00.000' AS DateTime), CAST(N'2017-09-25T00:00:00.000' AS DateTime), 5, N'images\events\0.png
')
INSERT [dbo].[Offer] ([offId], [offName], [offText], [offDateStart], [offDateEnd], [offDiscount], [offPicture]) VALUES (2, N'Salon du livre
', N'Le plus grand évènement du livre en France
', CAST(N'2017-03-16T00:00:00.000' AS DateTime), CAST(N'2017-03-19T00:00:00.000' AS DateTime), 5, N'images\events\1.png
')
INSERT [dbo].[Offer] ([offId], [offName], [offText], [offDateStart], [offDateEnd], [offDiscount], [offPicture]) VALUES (3, N'Stephen King, invité d''honneur
', N'L''essentiel des romans de Stephen King
', CAST(N'2017-09-07T00:00:00.000' AS DateTime), CAST(N'2017-10-25T00:00:00.000' AS DateTime), 5, N'images\events\3.png
')
INSERT [dbo].[Offer] ([offId], [offName], [offText], [offDateStart], [offDateEnd], [offDiscount], [offPicture]) VALUES (4, N'Foire au livre Albin Michel
', N'Albin Michel vous propose le meilleur de ses collections
', CAST(N'2017-01-14T00:00:00.000' AS DateTime), CAST(N'2017-01-31T00:00:00.000' AS DateTime), 0, N'images\events\4.png
')
SET IDENTITY_INSERT [dbo].[Offer] OFF
SET IDENTITY_INSERT [dbo].[OrderLine] ON 

INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (2, 57232, N'9782226399168', 2, 15.97, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (3, 57232, N'9782290138922', 1, 8.9, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (7, 57232, N'9782290152331', 3, 7.56, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (8, 57232, N'9782312015774', 3, 11.34, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (9, 57233, N'9782266272575', 5, 6.99, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (10, 57233, N'9782266272575', 2, 7.8, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (11, 57234, N'9782226328717', 5, 21.64, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (12, 57234, N'9782755614664', 12, 33.07, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (13, 57235, N'9782755614664', 1, 33.07, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (14, 57235, N'9782226399168', 2, 15.97, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (15, 57236, N'9782266276542', 2, 8.03, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (17, 57236, N'9782266272575', 2, 6.99, 5.5)
INSERT [dbo].[OrderLine] ([ordLineId], [purId], [booIsbn13], [ordLineQuantity], [ordBookPriceHT], [ordBookVAT]) VALUES (18, 57236, N'9782302064263', 2, 31.98, 20)
SET IDENTITY_INSERT [dbo].[OrderLine] OFF
INSERT [dbo].[OrderStatus] ([staCode], [staName]) VALUES (1, N'Commandé')
INSERT [dbo].[OrderStatus] ([staCode], [staName]) VALUES (2, N'Expédié')
INSERT [dbo].[OrderStatus] ([staCode], [staName]) VALUES (3, N'Livré')
INSERT [dbo].[OrderStatus] ([staCode], [staName]) VALUES (4, N'Retour en cours')
INSERT [dbo].[Payment] ([payId], [purId], [payValidate], [payChoice], [payDate]) VALUES (1, 57232, 1, N'carte Bancaire', CAST(N'2017-08-16T01:00:00.000' AS DateTime))
INSERT [dbo].[Payment] ([payId], [purId], [payValidate], [payChoice], [payDate]) VALUES (2, 57233, 1, N'carte Bancaire', CAST(N'2017-08-17T02:00:00.000' AS DateTime))
INSERT [dbo].[Payment] ([payId], [purId], [payValidate], [payChoice], [payDate]) VALUES (3, 57234, 1, N'carte Bancaire', CAST(N'2017-08-18T15:00:00.000' AS DateTime))
INSERT [dbo].[Payment] ([payId], [purId], [payValidate], [payChoice], [payDate]) VALUES (4, 57235, 1, N'carte Bancaire', CAST(N'2017-08-19T13:00:00.000' AS DateTime))
INSERT [dbo].[Payment] ([payId], [purId], [payValidate], [payChoice], [payDate]) VALUES (5, 57236, 1, N'carte Bancaire', CAST(N'2017-08-20T14:00:00.000' AS DateTime))
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782226328717')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782226393197')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782226399168')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782253083276')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782253132943')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782266130288')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782266272575')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782266276542')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782290138922')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782290145548')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782290152331')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782312015774')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Grand Poche 13x20cm
', N'9782747082600')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Magasine 22x28cm
', N'9782344020937')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Paysage Grand Format 33x28cm
', N'9782302064263')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Paysage Grand Format 33x28cm
', N'9782755614664')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Portrait Standard 20x25cm
', N'9781444799132')
INSERT [dbo].[Possession] ([forName], [booIsbn13]) VALUES (N'Portrait Standard 20x25cm
', N'9782412020869')
SET IDENTITY_INSERT [dbo].[Purchase] ON 

INSERT [dbo].[Purchase] ([purId], [cusId], [shippingCostId], [addDeliveryId], [addInvoiceId], [purIP], [shippingDate], [shippingNumber]) VALUES (57232, 1981, 1, 1, 2, N'207.105.185.229
', CAST(N'2017-08-24T15:30:00.000' AS DateTime), 15006)
INSERT [dbo].[Purchase] ([purId], [cusId], [shippingCostId], [addDeliveryId], [addInvoiceId], [purIP], [shippingDate], [shippingNumber]) VALUES (57233, 1981, 1, 1, 1, N'207.105.185.229

', NULL, NULL)
INSERT [dbo].[Purchase] ([purId], [cusId], [shippingCostId], [addDeliveryId], [addInvoiceId], [purIP], [shippingDate], [shippingNumber]) VALUES (57234, 1982, 1, 3, 3, N'80.29.91.9', NULL, NULL)
INSERT [dbo].[Purchase] ([purId], [cusId], [shippingCostId], [addDeliveryId], [addInvoiceId], [purIP], [shippingDate], [shippingNumber]) VALUES (57235, 1985, 1, 7, 8, N'59.37.245.21
', CAST(N'2017-08-22T15:00:00.000' AS DateTime), 15007)
INSERT [dbo].[Purchase] ([purId], [cusId], [shippingCostId], [addDeliveryId], [addInvoiceId], [purIP], [shippingDate], [shippingNumber]) VALUES (57236, 1986, 1, 8, 9, N'55.166.3.118
', NULL, NULL)
SET IDENTITY_INSERT [dbo].[Purchase] OFF
SET IDENTITY_INSERT [dbo].[Review] ON 

INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (2, 1981, N'9782226399168', 2, 2, N'situation connue douloureuse mais exprimée tellement de façon juste mais je le trouve trop court Sourire
', CAST(N'2017-08-20T00:00:00.000' AS DateTime), N'207.105.185.229

')
INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (3, 1981, N'9782290138922', 3, 3, N'Super livre, à lire avant d''aller voir le film au ciné', CAST(N'2017-08-20T00:00:00.000' AS DateTime), N'207.105.185.229
')
INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (4, 1981, N'9782290152331', 7, 5, N'j''ai achete ce livre il y a 2 semaines, deja fini', CAST(N'2017-08-20T00:00:00.000' AS DateTime), N'207.105.185.229
')
INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (5, 1981, N'9782312015774', 8, 4, NULL, CAST(N'2017-08-20T00:00:00.000' AS DateTime), N'207.105.185.229
')
INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (7, 1986, N'9782302064263', 18, 5, N'Magnifique ! Toutes mon enfance avec Zelda !
', CAST(N'2017-08-29T00:00:00.000' AS DateTime), N'55.166.3.118
')
INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (8, 1986, N'9782266272575', 17, 4, NULL, CAST(N'2017-08-28T00:00:00.000' AS DateTime), N'55.166.3.118
')
INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (9, 1981, N'9782266272575', 9, 3, N'Lu avidement après la première bouchée : un chaud-froid de sentiments pleins, de coeurs vides, de mots et de maux, bref un Nothomb grand millésime, avec le style, l'' horrible et le détestable dans un consommé d'' amour(s) manqué(s)....
', CAST(N'2017-08-26T00:00:00.000' AS DateTime), N'59.37.245.21
')
INSERT [dbo].[Review] ([revId], [cusId], [booIsbn13], [ordLineId], [revNote], [revComment], [revDate], [revIP]) VALUES (10, 1981, N'9782290138922', 10, 5, N'Ce livre est tellement captivant ! Que cela me donne envie de dévorer toute la saga !
', CAST(N'2017-08-22T00:00:00.000' AS DateTime), N'207.105.185.229
')
SET IDENTITY_INSERT [dbo].[Review] OFF
SET IDENTITY_INSERT [dbo].[Shipper] ON 

INSERT [dbo].[Shipper] ([ShipperId], [ShipperName]) VALUES (1, N'UPS')
INSERT [dbo].[Shipper] ([ShipperId], [ShipperName]) VALUES (2, N'La Poste')
INSERT [dbo].[Shipper] ([ShipperId], [ShipperName]) VALUES (3, N'TNT')
SET IDENTITY_INSERT [dbo].[Shipper] OFF
SET IDENTITY_INSERT [dbo].[ShippingCost] ON 

INSERT [dbo].[ShippingCost] ([shipId], [shipperId], [shipName], [shipCost]) VALUES (1, 1, N'Livraison Standard', 4.5)
INSERT [dbo].[ShippingCost] ([shipId], [shipperId], [shipName], [shipCost]) VALUES (2, 2, N'Livraison Standard', 4.5)
INSERT [dbo].[ShippingCost] ([shipId], [shipperId], [shipName], [shipCost]) VALUES (3, 3, N'Livraison Standard', 4.5)
SET IDENTITY_INSERT [dbo].[ShippingCost] OFF
INSERT [dbo].[StatusDisplay] ([staCode], [staName]) VALUES (0, N'Actif')
INSERT [dbo].[StatusDisplay] ([staCode], [staName]) VALUES (1, N'Inactif')
SET IDENTITY_INSERT [dbo].[SubTheme] ON 

INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (1, 1, N'bd & humour
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (2, 1, N'manga
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (3, 1, N'livre jeunesse
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (4, 1, N'livre ados et young adults
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (5, 2, N'roman et nouvelles
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (6, 2, N'romans en poche
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (7, 2, N'poésie, théâtre, lettres
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (8, 2, N'roman policier et thriller
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (9, 2, N'fantasy et science fiction
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (10, 3, N'actualite: politique, economie, societe
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (11, 3, N'art, cinema, musique
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (12, 3, N'esoterisme et pananormal
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (14, 3, N'histoire
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (15, 3, N'religions et spiritualités
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (16, 3, N'histoire
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (19, 3, N'religions et spiritualités
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (20, 3, N'sciences humaines
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (22, 4, N'cuisine et vins
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (23, 4, N'erotisme
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (24, 4, N'sante, bien être, puériculture
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (25, 5, N'scolaire et soutien scolaire
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (26, 5, N'rentrée universitaire
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (27, 5, N'concours et prépas
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (28, 6, N'dictionnaires et langues
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (29, 6, N'fantasy et science fiction
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (30, 6, N'entreprise, management
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (31, 6, N'livres informatique
', NULL)
INSERT [dbo].[SubTheme] ([subId], [theId], [subName], [subDescription]) VALUES (32, 6, N'sciences et medecine
', NULL)
SET IDENTITY_INSERT [dbo].[SubTheme] OFF
SET IDENTITY_INSERT [dbo].[Theme] ON 

INSERT [dbo].[Theme] ([theId], [theName], [theDescription]) VALUES (0, N'Inclassable', NULL)
INSERT [dbo].[Theme] ([theId], [theName], [theDescription]) VALUES (1, N'bd & jeunesse', NULL)
INSERT [dbo].[Theme] ([theId], [theName], [theDescription]) VALUES (2, N'littérature & fiction', NULL)
INSERT [dbo].[Theme] ([theId], [theName], [theDescription]) VALUES (3, N'art, culture & société', NULL)
INSERT [dbo].[Theme] ([theId], [theName], [theDescription]) VALUES (4, N'vie pratique', NULL)
INSERT [dbo].[Theme] ([theId], [theName], [theDescription]) VALUES (5, N'scolaire et universitaire', NULL)
INSERT [dbo].[Theme] ([theId], [theName], [theDescription]) VALUES (6, N'savoirs', NULL)
SET IDENTITY_INSERT [dbo].[Theme] OFF
INSERT [dbo].[Vat] ([vatCode], [vatRate], [vatName]) VALUES (0, 5.5, N'%')
INSERT [dbo].[Vat] ([vatCode], [vatRate], [vatName]) VALUES (1, 20, N'%')
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9781444799132', 15)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782226328717', 4)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782226393197', 2)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782226399168', 1)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782253014997', 17)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782253083276', 4)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782253132943', 4)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782266130288', 3)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782266272575', 6)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782266276542', 5)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782290138922', 4)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782290145548', 13)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782290152331', 8)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782302064263', 16)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782312015774', 12)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782344020937', 14)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782412020869', 7)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782747082600', 11)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782755614664', 9)
INSERT [dbo].[Writing] ([booIsbn13], [autId]) VALUES (N'9782755614664', 10)
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [fkCusChargeId] FOREIGN KEY([cusChargeId])
REFERENCES [dbo].[Customer] ([cusID])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [fkCusChargeId]
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [fkCusResidId] FOREIGN KEY([cusResidId])
REFERENCES [dbo].[Customer] ([cusID])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [fkCusResidId]
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [fkmyLibraryId] FOREIGN KEY([myLibraryId])
REFERENCES [dbo].[MyLibrary] ([myLibId])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [fkmyLibraryId]
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
ALTER TABLE [dbo].[GettingAccess]  WITH CHECK ADD  CONSTRAINT [fkAccessProfil] FOREIGN KEY([accProfilCode])
REFERENCES [dbo].[AccessProfile] ([accProfilCode])
GO
ALTER TABLE [dbo].[GettingAccess] CHECK CONSTRAINT [fkAccessProfil]
GO
ALTER TABLE [dbo].[Have]  WITH CHECK ADD  CONSTRAINT [fkBooHave] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[Have] CHECK CONSTRAINT [fkBooHave]
GO
ALTER TABLE [dbo].[Have]  WITH CHECK ADD  CONSTRAINT [fkOfferHave] FOREIGN KEY([offId])
REFERENCES [dbo].[Offer] ([offId])
GO
ALTER TABLE [dbo].[Have] CHECK CONSTRAINT [fkOfferHave]
GO
ALTER TABLE [dbo].[OrderLine]  WITH CHECK ADD  CONSTRAINT [fkBookIsbn13] FOREIGN KEY([booIsbn13])
REFERENCES [dbo].[Book] ([booIsbn13])
GO
ALTER TABLE [dbo].[OrderLine] CHECK CONSTRAINT [fkBookIsbn13]
GO
ALTER TABLE [dbo].[OrderLine]  WITH CHECK ADD  CONSTRAINT [fkPurchaseId] FOREIGN KEY([purId])
REFERENCES [dbo].[Purchase] ([purId])
GO
ALTER TABLE [dbo].[OrderLine] CHECK CONSTRAINT [fkPurchaseId]
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
REFERENCES [dbo].[Customer] ([cusID])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [fkCusId]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [fkShippingCostId] FOREIGN KEY([shippingCostId])
REFERENCES [dbo].[ShippingCost] ([shipId])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [fkShippingCostId]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [fkCusReview] FOREIGN KEY([cusId])
REFERENCES [dbo].[Customer] ([cusID])
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
