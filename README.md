### Prequisite Tools
[Apache Maven](https://maven.apache.org/download.cgi), command line build tool used for Java projects, necessary to have to run the proper dependencies. <br>
[openjdk-17](https://openjdk.org/projects/jdk/17/), the open-source JVM and JRE of Java. <br>

lsb_release -a # make sure it says Description: Ubuntu 22.04.01 LTS
sudo apt-get --yes update
sudo apt-get --yes upgrade
sudo apt-get --yes install openjdk-17-jre openjdk-17-jdk
sudo apt-get --yes install maven
# After this, go to your search bar and type 'command prompt'
# In the cmd prompt, type 'bash'
# You can now use your windows machine with the linux cli

# Once the cli is opened, make sure that the packages were installed
java -version # checks java version
javac -version # checks javac version
mvn --version # checks maven version, the added dash is important

# ------------IF openjdk-17-jdk IS NOT AVAILABLE---------------------------------------#
sudo apt-get --yes install openjdk-17-jdk-headless

#-------------IF -version SHOWS THAT IT IS NOT INSTALLED IN THE BASH PROMPT------------#
# Retype the installation commands provided in the first section
# If you receive an error that says something along the lines of "unmet dependencies"
# Type:
sudo apt-get --yes --fix-broken --fix-missing install
# This should fix the error, it installs the dependencies that are required to run
# To check, retype the version check commands
# If issues persist, please dm me and I will help

### How to install
Assuming you are in a bash shell. <br>
`git clone https://github.com/RyanHJohnston/soft-eng-project.git` <br>
`cd soft-eng-project` <br>
`mvn spring-boot:run` <br>
Then go to [localhost:8080](http://localhost:8080/) in url.

