node{
     
    def buildNumber = BUILD_NUMBER
    stage('SCM Checkout'){
        git url: 'https://github.com/Parashuraam/Java-Maven-Jenkins-Docker-Integration.git',branch: 'master'
    }
    
     stage(" Maven Clean Package"){
      def mavenHome =  tool name: "MAVEN", type: "maven"
      def mavenCMD = "${mavenHome}/bin/mvn"
      sh "${mavenCMD} clean package"
      
    } 
    
    stage('Build Docker Image'){
        sh "docker build -t parashuraam/java-web-app:${buildNumber} ."
    }
    
    stage('Push Docker Image'){
        withCredentials([string(credentialsId: 'Docker_Hub_Pwd', variable: 'Docker_Hub_Pwd')]) {
          sh "docker login -u parashuraam -p ${Docker_Hub_Pwd}"
        }
        sh "docker push parashuraam/java-web-app:${buildNumber}"
     }
	 
	 stage('Run Docker Image In Dev Server'){        
         sshagent(['DEMO']) {
          sh "ssh -o StrictHostKeyChecking=no root@192.168.43.230 docker stop javawebapp || true"
          sh "ssh -o StrictHostKeyChecking=no root@192.168.43.230 docker rm javawebapp || true"
          sh "ssh  root@192.168.43.230 docker run  -d -p 8080:8080 --name javawebapp parashuraam/java-web-app:${buildNumber}"
       }
       
    }
     
     
}
