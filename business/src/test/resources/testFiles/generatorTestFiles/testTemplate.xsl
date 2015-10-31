<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/userInformation">
		<html>
			<head>
				<title>Resume</title>
				<style>
					.nameinfo {
					margin-right: 50px;
					text-align: right;
					}
					table {
					border-collapse: collapse;
					margin-bottom: 100px;
					}
				</style>
			</head>

			<body>
				<div class="nameinfo">
					<h4>
						<xsl:value-of select="firstName" />
						<xsl:value-of select="lastName" />
						<p>
							<xsl:value-of select="position" />
						</p>
					</h4>
				</div>
				<table border="1" align="center">
					<tr>
						<td>
							<h3>Summary of Qualifications</h3>
						</td>
						<td>
							<xsl:value-of select="summary" />
						</td>
					</tr>
					<xsl:if test="projects">
						<tr>
							<td>
								<h3>Experience</h3>
							</td>
							<td>
								<xsl:for-each select="projects/project">
									<hr />
									<xsl:if test="description">
										<p>

											<h4>Project Description: </h4>
											<xsl:value-of select="description" />

										</p>
									</xsl:if>
									<xsl:if test="customer">
										<p>
											<h4>Customer: </h4>
											<xsl:value-of select="customer" />
										</p>
									</xsl:if>
									<xsl:if test="involvementDuration">
										<p>
											<h4>Involvement Duration: </h4>
											<xsl:value-of select="involvementDuration" />
										</p>
									</xsl:if>
									<xsl:if test="role">
										<p>
											<h4>Project Role: </h4>
											<xsl:value-of select="role" />
										</p>
									</xsl:if>
									<xsl:if test="teamSize">
										<p>
											<h4>Project Team Size: </h4>
											<xsl:value-of select="teamSize" />
										</p>
									</xsl:if>
									<xsl:if test="tools">
										<p>
											<h4>Tools and Technologies: </h4>
											<xsl:value-of select="tools" />
										</p>
									</xsl:if>
									<hr />
								</xsl:for-each>
							</td>
						</tr>
					</xsl:if>
					<xsl:if test="certifications">
						<tr>
							<td>
								<h3>Certifications</h3>
							</td>
							<td>
								<xsl:for-each select="certifications/certification">
									<hr />
									<p>
										<xsl:value-of select="name" />
									</p>
									<p>
										<xsl:value-of select="yearReceived" />
									</p>
									<hr />
								</xsl:for-each>
							</td>
						</tr>
					</xsl:if>
					<xsl:if test="educations">
						<tr>
							<td>
								<h3>Education</h3>
							</td>
							<td>
								<xsl:for-each select="educations/education">
									<hr />
									<p>
										<xsl:value-of select="degreeReceived" />
									</p>
									<p>
										<xsl:value-of select="schoolName" />
									</p>
									<p>
										<xsl:value-of select="department" />
									</p>
									<p>
										<xsl:value-of select="graduationYear" />
									</p>
									<hr />
								</xsl:for-each>
							</td>
						</tr>
					</xsl:if>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet> 