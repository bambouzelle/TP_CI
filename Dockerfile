# Utiliser l'image officielle Jenkins LTS comme base
FROM jenkins/jenkins:lts

# Utiliser root pour installer les packages
USER root

# Installer le JDK 21
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.deb && \
    dpkg -i jdk-21_linux-x64_bin.deb && \
    rm jdk-21_linux-x64_bin.deb

# Mettre à jour les alternatives pour utiliser JDK 21 par défaut
RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-21/bin/java 1 && \
    update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-21/bin/javac 1

# Vérifier l'installation de Java
RUN java -version

# Installer Maven
RUN apt-get install -y maven

# Passer à l'utilisateur Jenkins
USER jenkins

# Exposer les ports par défaut de Jenkins
EXPOSE 8080
EXPOSE 50000
