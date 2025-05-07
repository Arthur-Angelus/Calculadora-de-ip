package br.dev.arthur.calculadoraDeIP.model;

public class calculadora {
	
	private int cidr;
	private int primeiroOcteto;
	private StringBuilder mascaraBinaria;
	private String mascaraDecimal;
	private String ipClass;
	private String ip;
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getCidr() {
		return cidr;
	}
	
	public void setCidr(int cidr) {
		this.cidr = cidr;
	}
	
	public int getPrimeiroOcteto() {
		return primeiroOcteto;
	}
	
	public void setPrimeiroOcteto(int primeiroOcteto) {
		this.primeiroOcteto = primeiroOcteto;
	}
	
	public StringBuilder getMascaraBinaria() {
		return mascaraBinaria;
	}

	public void setMascaraBinaria(StringBuilder mascaraBinaria) {
		this.mascaraBinaria = mascaraBinaria;
	}

	public String getMascaraDecimal() {
		return mascaraDecimal;
	}

	public void setMascaraDecimal(String mascaraDecimal) {
		this.mascaraDecimal = mascaraDecimal;
	}

	public String getIpClass() {
		return ipClass;
	}

	public void setIpClass(String ipClass) {
		this.ipClass = ipClass;
	}
	
	
	
	public void ClassificadoraDeIp(String ip, int cidr) {
        this.ip = ip;
        this.cidr = cidr;
        this.primeiroOcteto = Integer.parseInt(ip.split("\\.")[0]);
        this.mascaraBinaria = new StringBuilder();
        this.mascaraDecimal = "";
        this.ipClass = "";
        classificarIp();
	}
	
	public void classificarIp() {
        // Classificando a classe do IP
        if (primeiroOcteto >= 1 && primeiroOcteto <= 127) {
            ipClass = "A";
        } else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
            ipClass = "B";
        } else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
            ipClass = "C";
        } else if (primeiroOcteto >= 224 && primeiroOcteto <= 239) {
            ipClass = "D";
        } else if (primeiroOcteto >= 240 && primeiroOcteto <= 255) {
            ipClass = "E";
        } else if (primeiroOcteto > 255) {
            ipClass = "desconhecido";
        }
        
        int ipsDisponiveis = (int) Math.pow(2, 32 - cidr) - 2;
        System.out.println("Classe do IP: " + ipClass);
        System.out.println("Máscara de sub-rede (binário): " + mascaraBinaria);
        System.out.println("Máscara de sub-rede (decimal): " + mascaraDecimal);
        System.out.println("IPs disponíveis: " + ipsDisponiveis);
	
	}
	
	private String calculateBinaryMask(int cidr) {
		if (cidr < 0 || cidr > 32) {
			return "Máscara CIDR inválida";
		}
		StringBuilder binaryMask = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			if (i < cidr) {
				binaryMask.append("1");
			} else {
				binaryMask.append("0");
			}
			if ((i + 1) % 8 == 0 && i < 31) {
				binaryMask.append(".");
			}
		}
		return binaryMask.toString();
	}
}
