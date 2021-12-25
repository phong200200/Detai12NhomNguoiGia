USE [master]
GO
/****** Object:  Database [DoAnLTM]    Script Date: 25/12/2021 3:11:29 PM ******/
CREATE DATABASE [DoAnLTM]
GO
ALTER DATABASE [DoAnLTM] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DoAnLTM].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DoAnLTM] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DoAnLTM] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DoAnLTM] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DoAnLTM] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DoAnLTM] SET ARITHABORT OFF 
GO
ALTER DATABASE [DoAnLTM] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DoAnLTM] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DoAnLTM] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DoAnLTM] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DoAnLTM] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DoAnLTM] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DoAnLTM] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DoAnLTM] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DoAnLTM] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DoAnLTM] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DoAnLTM] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DoAnLTM] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DoAnLTM] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DoAnLTM] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DoAnLTM] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DoAnLTM] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DoAnLTM] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DoAnLTM] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DoAnLTM] SET  MULTI_USER 
GO
ALTER DATABASE [DoAnLTM] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DoAnLTM] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DoAnLTM] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DoAnLTM] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DoAnLTM] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DoAnLTM] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DoAnLTM] SET QUERY_STORE = OFF
GO
USE [DoAnLTM]
GO
/****** Object:  Table [dbo].[DiemSV]    Script Date: 25/12/2021 3:11:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiemSV](
	[MSSV] [char](10) NOT NULL,
	[HoTen] [nvarchar](64) NOT NULL,
	[DiemToan] [nchar](16) NOT NULL,
	[DiemVan] [nchar](16) NOT NULL,
	[DiemAnh] [nchar](16) NOT NULL,
 CONSTRAINT [PK_DiemSV] PRIMARY KEY CLUSTERED 
(
	[MSSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [DoAnLTM] SET  READ_WRITE 
GO
