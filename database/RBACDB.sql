USE [RBACDB]
GO
/****** Object:  Table [dbo].[Account_Type]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account_Type](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Action]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Action](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
	[IP_Address] [varchar](200) NULL,
	[Designation] [int] NULL,
	[from_date] [date] NULL,
	[to_date] [date] NULL,
	[from_time] [datetime] NULL,
	[to_time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Action_Level]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Action_Level](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ActionLevel_Action]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActionLevel_Action](
	[Action] [int] NOT NULL,
	[Action_Level] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Action] ASC,
	[Action_Level] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Designation]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Designation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Object]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Object](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
	[type] [int] NULL,
	[IP_Address] [varchar](200) NULL,
	[Designation] [int] NULL,
	[from_date] [date] NULL,
	[to_date] [date] NULL,
	[from_time] [datetime] NULL,
	[to_time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Object_container]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Object_container](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Object_Type]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Object_Type](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ObjectContainer_Obj]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ObjectContainer_Obj](
	[ObjContainer] [int] NOT NULL,
	[Obj] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ObjContainer] ASC,
	[Obj] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Permission]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Permission](
	[Action] [int] NOT NULL,
	[Obj] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Action] ASC,
	[Obj] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
	[IP_Address] [varchar](200) NULL,
	[Designation] [int] NULL,
	[from_date] [date] NULL,
	[to_date] [date] NULL,
	[from_time] [datetime] NULL,
	[to_time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 3/13/2020 2:13:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[username] [varchar](200) NOT NULL,
	[password] [varchar](200) NULL,
	[Type] [int] NULL,
	[IP_Address] [varchar](200) NULL,
	[Designation] [int] NULL,
	[from_date] [date] NULL,
	[to_date] [date] NULL,
	[from_time] [datetime] NULL,
	[to_time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account_Type] ON 

INSERT [dbo].[Account_Type] ([id], [name]) VALUES (1, N'admin')
INSERT [dbo].[Account_Type] ([id], [name]) VALUES (2, N'user')
SET IDENTITY_INSERT [dbo].[Account_Type] OFF
SET IDENTITY_INSERT [dbo].[Action] ON 

INSERT [dbo].[Action] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1, N'read', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Action] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (2, N'edit', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Action] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (3, N'delete', N'192.168.112.1', 2, CAST(N'2020-02-16' AS Date), CAST(N'2020-02-26' AS Date), CAST(N'1970-01-01T07:00:00.000' AS DateTime), CAST(N'1970-01-01T10:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Action] OFF
SET IDENTITY_INSERT [dbo].[Action_Level] ON 

INSERT [dbo].[Action_Level] ([id], [name]) VALUES (1, N'act-Level-1 ')
INSERT [dbo].[Action_Level] ([id], [name]) VALUES (2, N'act-Level-2')
INSERT [dbo].[Action_Level] ([id], [name]) VALUES (3, N'act-Level-3')
SET IDENTITY_INSERT [dbo].[Action_Level] OFF
INSERT [dbo].[ActionLevel_Action] ([Action], [Action_Level]) VALUES (1, 1)
INSERT [dbo].[ActionLevel_Action] ([Action], [Action_Level]) VALUES (2, 1)
INSERT [dbo].[ActionLevel_Action] ([Action], [Action_Level]) VALUES (3, 1)
SET IDENTITY_INSERT [dbo].[Designation] ON 

INSERT [dbo].[Designation] ([id], [name]) VALUES (1, N'Officer')
INSERT [dbo].[Designation] ([id], [name]) VALUES (2, N'Assistant')
INSERT [dbo].[Designation] ([id], [name]) VALUES (3, N'Director')
INSERT [dbo].[Designation] ([id], [name]) VALUES (4, N'Manager')
SET IDENTITY_INSERT [dbo].[Designation] OFF
SET IDENTITY_INSERT [dbo].[Object] ON 

INSERT [dbo].[Object] ([id], [name], [type], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1, N'object-a ', 1, N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Object] ([id], [name], [type], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (2, N'object-b ', 1, N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Object] ([id], [name], [type], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (3, N'object-c ', 1, N'192.168.112.1', 2, CAST(N'2020-02-16' AS Date), CAST(N'2020-02-26' AS Date), CAST(N'1970-01-01T07:00:00.000' AS DateTime), CAST(N'1970-01-01T10:00:00.000' AS DateTime))
INSERT [dbo].[Object] ([id], [name], [type], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (4, N'object-d ', 1, N'192.168.112.1', 2, CAST(N'2020-02-16' AS Date), CAST(N'2020-02-26' AS Date), CAST(N'1970-01-01T07:00:00.000' AS DateTime), CAST(N'1970-01-01T10:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Object] OFF
SET IDENTITY_INSERT [dbo].[Object_container] ON 

INSERT [dbo].[Object_container] ([id], [name]) VALUES (1, N'obj-Container-1')
INSERT [dbo].[Object_container] ([id], [name]) VALUES (2, N'obj-Container-2')
INSERT [dbo].[Object_container] ([id], [name]) VALUES (3, N'obj-Container-3 ')
SET IDENTITY_INSERT [dbo].[Object_container] OFF
SET IDENTITY_INSERT [dbo].[Object_Type] ON 

INSERT [dbo].[Object_Type] ([id], [name]) VALUES (1, N'text')
INSERT [dbo].[Object_Type] ([id], [name]) VALUES (2, N'number')
SET IDENTITY_INSERT [dbo].[Object_Type] OFF
INSERT [dbo].[ObjectContainer_Obj] ([ObjContainer], [Obj]) VALUES (1, 1)
INSERT [dbo].[ObjectContainer_Obj] ([ObjContainer], [Obj]) VALUES (1, 2)
INSERT [dbo].[ObjectContainer_Obj] ([ObjContainer], [Obj]) VALUES (1, 3)
INSERT [dbo].[ObjectContainer_Obj] ([ObjContainer], [Obj]) VALUES (1, 4)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (1, 1)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (1, 2)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (1, 3)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (1, 4)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (2, 1)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (2, 2)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (2, 3)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (2, 4)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (3, 1)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (3, 2)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (3, 3)
INSERT [dbo].[Permission] ([Action], [Obj]) VALUES (3, 4)
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1, N'role-1', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1005, N'role-2', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1006, N'role-3', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1007, N'role-4', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1008, N'role-5', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1009, N'role-6', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1010, N'role-7', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1011, N'role-8', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1012, N'role-9', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1013, N'role-10', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1014, N'role-11', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1015, N'role-12', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1016, N'role-13', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1017, N'role-14', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1018, N'role-15', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1019, N'role-16', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1020, N'role-17', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1021, N'role-18', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1022, N'role-19', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1023, N'role-20', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1024, N'role-21', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1025, N'role-22', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1026, N'role-23', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1027, N'role-24', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1028, N'role-25', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1029, N'role-26', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1030, N'role-27', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1031, N'role-28', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1032, N'role-29', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
INSERT [dbo].[Role] ([id], [name], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (1033, N'role-30', N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Role] OFF
INSERT [dbo].[User] ([username], [password], [Type], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (N'admin', N'123456', 1, N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'2020-02-14T21:06:16.910' AS DateTime), CAST(N'2020-02-24T21:06:16.910' AS DateTime))
INSERT [dbo].[User] ([username], [password], [Type], [IP_Address], [Designation], [from_date], [to_date], [from_time], [to_time]) VALUES (N'user', N'123', 2, N'192.168.112.1', 1, CAST(N'2020-02-14' AS Date), CAST(N'2020-02-24' AS Date), CAST(N'1970-01-01T06:00:00.000' AS DateTime), CAST(N'1970-01-01T09:00:00.000' AS DateTime))
ALTER TABLE [dbo].[ActionLevel_Action]  WITH CHECK ADD FOREIGN KEY([Action])
REFERENCES [dbo].[Action] ([id])
GO
ALTER TABLE [dbo].[ActionLevel_Action]  WITH CHECK ADD FOREIGN KEY([Action_Level])
REFERENCES [dbo].[Action_Level] ([id])
GO
ALTER TABLE [dbo].[Object]  WITH CHECK ADD FOREIGN KEY([Designation])
REFERENCES [dbo].[Designation] ([id])
GO
ALTER TABLE [dbo].[Object]  WITH CHECK ADD FOREIGN KEY([type])
REFERENCES [dbo].[Object_Type] ([id])
GO
ALTER TABLE [dbo].[ObjectContainer_Obj]  WITH CHECK ADD FOREIGN KEY([ObjContainer])
REFERENCES [dbo].[Object_container] ([id])
GO
ALTER TABLE [dbo].[ObjectContainer_Obj]  WITH CHECK ADD FOREIGN KEY([Obj])
REFERENCES [dbo].[Object] ([id])
GO
ALTER TABLE [dbo].[Permission]  WITH CHECK ADD FOREIGN KEY([Action])
REFERENCES [dbo].[Action] ([id])
GO
ALTER TABLE [dbo].[Permission]  WITH CHECK ADD FOREIGN KEY([Obj])
REFERENCES [dbo].[Object] ([id])
GO
ALTER TABLE [dbo].[Role]  WITH CHECK ADD FOREIGN KEY([Designation])
REFERENCES [dbo].[Designation] ([id])
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD FOREIGN KEY([Designation])
REFERENCES [dbo].[Designation] ([id])
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD FOREIGN KEY([Type])
REFERENCES [dbo].[Account_Type] ([id])
GO
