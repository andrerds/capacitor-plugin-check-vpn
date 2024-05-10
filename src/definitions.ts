 export interface CheckVpnPlugin {
  getVpnStatus(): Promise<{ vpnStatus: string | undefined }>;
 }