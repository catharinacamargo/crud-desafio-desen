USE [SICOP]
GO

/****** Object:  Table [dbo].[Tb_Acesso_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Acesso_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Descricao] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Tb_Acesso_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Cliente_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Cliente_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [varchar](250) NOT NULL,
	[CPF] [varchar](14) NOT NULL,
 CONSTRAINT [PK_Tb_Cliente_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Email_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Email_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](250) NOT NULL,
	[Fk_Cliente] [int] NOT NULL,
 CONSTRAINT [PK_Tb_Email_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Endereco_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Endereco_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CEP] [varchar](50) NOT NULL,
	[Logradouro] [varchar](250) NOT NULL,
	[Bairro] [varchar](250) NOT NULL,
	[Complemento] [varchar](550) NULL,
	[Cidade] [varchar](250) NOT NULL,
	[UF] [varchar](2) NOT NULL,
	[Fk_Cliente_Desafio] [int] NOT NULL,
	[Fk_Tipo_Endereco] [int] NOT NULL,
 CONSTRAINT [PK_Tb_Endereco_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Telefone_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Telefone_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[DDD] [varchar](5) NOT NULL,
	[Telefone] [varchar](25) NOT NULL,
	[Fk_Tipo_Telefone] [int] NOT NULL,
	[Fk_Cliente] [int] NOT NULL,
 CONSTRAINT [PK_Tb_Telefone_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Tipo_Endereco_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Tipo_Endereco_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Descricao] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Tb_Tipo_Endereco_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Tipo_Telefone_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Tipo_Telefone_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Descricao] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Tb_Tipo_Telefone_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Tipo_Usuario_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Tipo_Usuario_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Descricao] [varchar](50) NOT NULL,
	[Fk_Acesso_Desafio] [int] NOT NULL,
 CONSTRAINT [PK_Tb_Tipo_Usuario_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Tb_Usuario_Desafio]    Script Date: 15/04/2019 14:58:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Tb_Usuario_Desafio](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Usuario] [varchar](50) NOT NULL,
	[Senha] [varchar](50) NOT NULL,
	[Fk_Tipo_Usuario_Desafio] [int] NOT NULL,
 CONSTRAINT [PK_Tb_Usuario_Desafio] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Tb_Email_Desafio]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Email_Desafio_Tb_Cliente_Desafio] FOREIGN KEY([Fk_Cliente])
REFERENCES [dbo].[Tb_Cliente_Desafio] ([Id])
GO

ALTER TABLE [dbo].[Tb_Email_Desafio] CHECK CONSTRAINT [FK_Tb_Email_Desafio_Tb_Cliente_Desafio]
GO

ALTER TABLE [dbo].[Tb_Endereco_Desafio]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Endereco_Desafio_Tb_Cliente_Desafio] FOREIGN KEY([Fk_Cliente_Desafio])
REFERENCES [dbo].[Tb_Cliente_Desafio] ([Id])
GO

ALTER TABLE [dbo].[Tb_Endereco_Desafio] CHECK CONSTRAINT [FK_Tb_Endereco_Desafio_Tb_Cliente_Desafio]
GO

ALTER TABLE [dbo].[Tb_Endereco_Desafio]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Endereco_Desafio_Tb_Tipo_Endereco_Desafio] FOREIGN KEY([Fk_Tipo_Endereco])
REFERENCES [dbo].[Tb_Tipo_Endereco_Desafio] ([Id])
GO

ALTER TABLE [dbo].[Tb_Endereco_Desafio] CHECK CONSTRAINT [FK_Tb_Endereco_Desafio_Tb_Tipo_Endereco_Desafio]
GO

ALTER TABLE [dbo].[Tb_Telefone_Desafio]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Telefone_Desafio_Tb_Cliente_Desafio] FOREIGN KEY([Fk_Cliente])
REFERENCES [dbo].[Tb_Cliente_Desafio] ([Id])
GO

ALTER TABLE [dbo].[Tb_Telefone_Desafio] CHECK CONSTRAINT [FK_Tb_Telefone_Desafio_Tb_Cliente_Desafio]
GO

ALTER TABLE [dbo].[Tb_Telefone_Desafio]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Telefone_Desafio_Tb_Tipo_Telefone_Desafio] FOREIGN KEY([Fk_Tipo_Telefone])
REFERENCES [dbo].[Tb_Tipo_Telefone_Desafio] ([Id])
GO

ALTER TABLE [dbo].[Tb_Telefone_Desafio] CHECK CONSTRAINT [FK_Tb_Telefone_Desafio_Tb_Tipo_Telefone_Desafio]
GO

ALTER TABLE [dbo].[Tb_Tipo_Usuario_Desafio]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Tipo_Usuario_Desafio_Tb_Acesso_Desafio] FOREIGN KEY([Fk_Acesso_Desafio])
REFERENCES [dbo].[Tb_Acesso_Desafio] ([Id])
GO

ALTER TABLE [dbo].[Tb_Tipo_Usuario_Desafio] CHECK CONSTRAINT [FK_Tb_Tipo_Usuario_Desafio_Tb_Acesso_Desafio]
GO

ALTER TABLE [dbo].[Tb_Usuario_Desafio]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Usuario_Desafio_Tb_Tipo_Usuario_Desafio] FOREIGN KEY([Fk_Tipo_Usuario_Desafio])
REFERENCES [dbo].[Tb_Tipo_Usuario_Desafio] ([Id])
GO

ALTER TABLE [dbo].[Tb_Usuario_Desafio] CHECK CONSTRAINT [FK_Tb_Usuario_Desafio_Tb_Tipo_Usuario_Desafio]
GO


